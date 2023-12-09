package com.enotes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 2000)
	private String title;
	
	@Column(length = 10000)
	 private String description;
	
	private String date;
	
	@ManyToOne
	private Student student;

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}


	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notes(int id, String title, String description, String date, Student student) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.student = student;
	}

	@Override
	public String toString() {
		return "Notes [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date + ", student="
				+ student + "]";
	}

	public <Student> void setStudent(Student student2) {
		// TODO Auto-generated method stub
		
	}

}
