package com.enotes.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.enotes.dao.StudentDao;
import com.enotes.model.Notes;
import com.enotes.model.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao studentDao;


	
	@RequestMapping("/addNotes")
	public String addNotes() {
		return "add_notes";
	}
	@RequestMapping("/viewNotes")
	public  String viewNotes(HttpSession session, Model model) {
           Student student = (Student) session.getAttribute("studentObj");
	       List<Notes> notes = studentDao.getNotesByStudent(student);
	       model.addAttribute("list", notes);

	       return "view_notes";
	 }
	
	@RequestMapping("/editNotes")
	public String editNotes(@RequestParam("id") int id,Model m) {
		Notes notes=studentDao.getNotesById(id);
		m.addAttribute("notes",notes);
		return "edit_notes";
	}
	

	@RequestMapping(path="/updateNotes", method=RequestMethod.POST)
	public String updateNotes(@ModelAttribute Notes notes, HttpSession session) {
		Student student = (Student) session.getAttribute("studentObj");
		notes.setStudent(student);
		notes.setDate(LocalDateTime.now().toString());
		System.out.println(notes);
		
		studentDao.updateNotes(notes);
		session.setAttribute("msg", "Notes Update sucessfully");
		return "redirect:/student/viewNotes";
	}
	

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("studentObj");
		session.setAttribute("msg", "logout sucessfully");
		return "login";
	}	
	
	@RequestMapping(path = "/saveNotes", method = RequestMethod.POST)
	public String saveNotes(@ModelAttribute Notes notes, HttpSession session) {
	    Student student=(Student)session.getAttribute("studentObj");
	    notes.setDate(LocalDateTime.now().toString());
	    notes.setStudent(student);
	    studentDao.saveNotes(notes);
	    session.setAttribute("msg", "Notes Added successfully");
	    return "redirect:/student/addNotes";
	}

	@RequestMapping("/deleteNotes")
	public String deleteNotes(@RequestParam("id") int id,HttpSession session ) {
		studentDao.deleteNotes(id);
		session.setAttribute("msg","Notes Delete Sucessfully");
		return "redirect:/student/viewNotes";
	}
}
