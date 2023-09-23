package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ExamSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	Class classs ;
	String examName ;
	@ManyToOne
	Section section ;
	@ManyToOne
	Subject subject ;
	String date ;
	String timeFrom ;
	String timeTo ;
	@ManyToOne
	Classroom room;
	
	public ExamSchedule() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Class getClasss() {
		return classs;
	}

	public void setClasss(Class classs) {
		this.classs = classs;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public Classroom getRoom() {
		return room;
	}

	public void setRoom(Classroom room) {
		this.room = room;
	}
	
	
}
