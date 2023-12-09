package com.enotes.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.enotes.model.Notes;
import com.enotes.model.Student;

@Transactional
@Repository
public class StudentDaoImpl  implements StudentDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	private HibernateTemplate hibernateTemplante;

	public int saveStudent(Student student) {
		int i= (Integer)hibernateTemplate.save(student);
		return i;
	}

	public Student login(String email, String password) {
	    String sql = "FROM Student WHERE email = :em AND password = :pwd";

	    Student student = hibernateTemplate.execute(session -> {
	        Query query = session.createQuery(sql);
	        query.setParameter("em", email);
	        query.setParameter("pwd", password);
	        return (Student) query.uniqueResult();
	    });

	    return student;
	}

	@Override
	public int saveNotes(Notes notes) {
		int i =(Integer) hibernateTemplate.save(notes);
		return i;
	}

	@Override
	public List<Notes> getNotesByStudent(Student student) {
	    String sql = "FROM Notes WHERE student = :stud";

	    List<Notes> list = hibernateTemplate.execute(s -> {
	        Query q = s.createQuery(sql);
	        q.setParameter("stud", student);
	        return q.getResultList();
	    });

	    return list;
	}

	

	@Override
	public Notes getNotesById(int id) {
		Notes notes=hibernateTemplate.get(Notes.class, id);
		return notes;
	}

	@Override
	public void deleteNotes(int id) {
		Notes notes=hibernateTemplate.get(Notes.class, id);
		hibernateTemplate.delete(notes);
		
	}

	@Override
	public void updateNotes(Notes notes) {
		hibernateTemplate.update(notes);	
	}
}
