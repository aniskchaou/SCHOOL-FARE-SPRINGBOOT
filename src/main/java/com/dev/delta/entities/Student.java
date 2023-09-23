package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name ;
	@ManyToOne
	Parent parentt;
	String dateofBirth;
	String gender;
	String male;
	String bloodGroup;	
	String email;
	String phone;
	String address;
	String country;
	@ManyToOne
	Class classs ;
	@ManyToOne
	Section section;
	String groupp;
	String photo;
	String remarks;
	String username ;
	String password ;
	
	public Student() {
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

	public Parent getParentt() {
		return parentt;
	}

	public void setParentt(Parent parentt) {
		this.parentt = parentt;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getGroupp() {
		return groupp;
	}

	public void setGroupp(String groupp) {
		this.groupp = groupp;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
