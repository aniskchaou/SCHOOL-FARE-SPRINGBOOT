package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Syllabus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String title ;
	String description ;
	@ManyToOne
	Class classs ;
	String file ;
	
	public Syllabus() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	

	public Class getClasss() {
		return classs;
	}

	public void setClasss(Class classs) {
		this.classs = classs;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	

}
