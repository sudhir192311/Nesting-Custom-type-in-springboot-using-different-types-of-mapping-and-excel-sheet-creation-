package com.example.devtools.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.devtools.entities.Book;



public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public Book findById(int id);

}
