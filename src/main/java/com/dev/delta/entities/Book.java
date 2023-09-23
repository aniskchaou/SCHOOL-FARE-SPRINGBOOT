package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
String book;
String author;
String price;
@ManyToOne
Class classs;
String description;
String status;

public Book() {
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getBook() {
	return book;
}

public void setBook(String book) {
	this.book = book;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public Class getClasss() {
	return classs;
}

public void setClasss(Class classs) {
	this.classs = classs;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}



}
