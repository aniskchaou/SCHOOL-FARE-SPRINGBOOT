package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name ;
	@ManyToOne
	Category category ;
	String capacity ;
	@ManyToOne
	Class classs ;
	@ManyToOne
	Teacher teacher ;
	String note;
	
	public Section() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public Class getClasss() {
		return classs;
	}

	public void setClasss(Class classs) {
		this.classs = classs;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
