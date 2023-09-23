package com.dev.delta.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.delta.entities.Book;
import com.dev.delta.services.BookService;

@Controller
public class BookController {
	/**
	 * bookService
	 */
	@Autowired
	private BookService bookService;

	/**
	 * getbooks
	 * @param model
	 * @return
	 */
	@GetMapping("/books")
	public String getbooks(Model model) {
		List<Book> countrries = bookService.getBooks();
		model.addAttribute("books", countrries);
		return "book/index";
	}


	@GetMapping("/addbook")
	public String addBooksd(Model model) {
		return "book/add";
	}

	/**
	 * addBook
	 * @param book
	 * @param model
	 * @return
	 */
	@PostMapping("/addbook")
	public String addBook(Book book, Model model) {
		bookService.save(book);
		return "redirect:/books";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/book/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Book book = bookService.findById(id).get();
		model.addAttribute("book", book);

		return "book/edit";
	}

	/**
	 * updateBook
	 * @param id
	 * @param book
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatebook/{id}")
	public String updateBook(@PathVariable("id") long id, @Validated Book book, 
			BindingResult result,
			Model model) {

		bookService.save(book);
		return "redirect:/books";
	}

	/**
	 * deleteBook
	 * @param id
	 * @return
	 */
	@GetMapping("/deletebook/{id}")
	@Transactional
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.delete(id);
		return "redirect:/books";
	}
	
}
