package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Book;
import com.dev.delta.repositories.BookRepository;

@Service
public class BookService {
	/**
	 * bookRepository
	 */
	@Autowired
	private BookRepository bookRepository;
	

	/**
	 * getBooks
	 * @return
	 */
	public java.util.List<Book> getBooks()
	{
		return bookRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return bookRepository.count();
	}

	/**
	 * save
	 * @param book
	 */
	public void save(Book book)
	{
		bookRepository.save(book);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		bookRepository.delete(bookRepository.findById(id).get());
	}
}
