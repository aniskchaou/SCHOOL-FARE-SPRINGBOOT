package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String className;
	@ManyToOne
	Teacher teacher;
	String type;
	String passMark ;
	String finalMark ;
	String subjectName ;
	String subjectAuthor;
	String subjectCode ;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassMark() {
		return passMark;
	}

	public void setPassMark(String passMark) {
		this.passMark = passMark;
	}

	public String getFinalMark() {
		return finalMark;
	}

	public void setFinalMark(String finalMark) {
		this.finalMark = finalMark;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectAuthor() {
		return subjectAuthor;
	}

	public void setSubjectAuthor(String subjectAuthor) {
		this.subjectAuthor = subjectAuthor;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	
}
