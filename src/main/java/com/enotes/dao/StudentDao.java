package com.enotes.dao;

import java.util.List;

import com.enotes.model.Notes;
import com.enotes.model.Student;

public interface StudentDao {

	public int saveStudent(Student student);
	
	public Student login(String email,String password);
	
	public int saveNotes(Notes notes);
	
	public List<Notes> getNotesByStudent(Student student);
	
	public Notes getNotesById(int id);
	
	public void deleteNotes(int id);
	
	public void updateNotes(Notes notes);
}
