package com.enotes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.enotes.dao.StudentDao;
import com.enotes.model.Student;

@Controller
public class HomeController {

	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
//	@RequestMapping("/addNotes")
//	public String addNotes() {
//		return "add_notes";
//	}
//	@RequestMapping("/viewNotes")
//	public String viewNotes() {
//		return "view_notes";
//	}
//	
//	@RequestMapping("/editNotes")
//	public String editNotes() {
//		return "edit_notes";
//	}
	
	@RequestMapping(path="/registerStudent", method=RequestMethod.POST)
	public String registerStudent(@ModelAttribute Student student,HttpSession session) {
		
		//System.out.println(student);
		
		studentDao.saveStudent(student);
		session.setAttribute("msg", "Register Sucessfully");
		return "redirect:/register";
	}
	
	@RequestMapping(path="/loginStudent", method=RequestMethod.POST)
	public String loginStudent(@RequestParam("email") String email,@RequestParam("password") String password,
			  HttpSession session) {
		
		Student student=studentDao.login(email, password);
		if(student!=null){
			session.setAttribute("studentObj", student);
			return "redirect:/home";
		}else {
			session.setAttribute("msg", "email & password invalid");
			return "redirect:/login";
		}
		
	}
}
