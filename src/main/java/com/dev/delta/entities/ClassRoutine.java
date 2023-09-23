package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
public class ClassRoutine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	Classroom classroom;
	@ManyToOne
	Class classs;
	@ManyToOne
	Section section;
	@ManyToOne
	Subject subject;
	String day;
	String start;
	String end;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public Class getClasss() {
		return classs;
	}
	public void setClasss(Class classs) {
		this.classs = classs;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	

	
	
	
	
}
