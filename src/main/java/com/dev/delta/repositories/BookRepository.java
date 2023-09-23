package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

}
