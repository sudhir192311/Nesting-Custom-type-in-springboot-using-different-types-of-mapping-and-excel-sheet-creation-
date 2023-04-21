package com.example.devtools.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.devtools.entities.Book;
import com.example.devtools.entities.TestApi;
import com.example.devtools.services.BookService;

@RestController
public class MainController {
	@Autowired
	private BookService bookService;

	public MainController(BookService bookService) {
		this.bookService = bookService;

	}

	@GetMapping(value = "/test")
	public ResponseEntity<TestApi> getData() {
		return new ResponseEntity<>(bookService.CosumerApi(), HttpStatus.OK);

	}

	@GetMapping(value = "/excel")
	public ResponseEntity<String> getExcelData() throws IOException {
		this.bookService.getActualData();
		return new ResponseEntity<String>("Excel done", HttpStatus.OK);
	}
	
	

	@GetMapping("/getExcelData")
	public List<Book> getExcelDataBase() throws IOException {

		return this.bookService.getData();
	}
	
//	@GetMapping(value = "/excel")
//	public ResponseEntity<Book> getExcelDataBase() throws IOException {
//		this.bookService.getData();
//		return new ResponseEntity<Book>("Excel done form Databse", HttpStatus.OK);
//	}

	@GetMapping(value = "/apiResponseList")
	public ResponseEntity<TestApi[]> apiResponseList() throws IOException {
		return new ResponseEntity<>(bookService.cosumerApiLsit(), HttpStatus.OK);

	}

	@PostMapping("/test")
	public ResponseEntity<TestApi> PostTest(@RequestBody TestApi testApi) {
		return new ResponseEntity<>(bookService.AddTest(testApi), HttpStatus.OK);

	}

	@DeleteMapping("/test")
	public ResponseEntity<String> deleteTest(@RequestBody TestApi testApi) {
		return new ResponseEntity<>(bookService.DeleteTest(), HttpStatus.OK);

	}

	@PutMapping("/test")
	public ResponseEntity<String> updateTest(@RequestBody TestApi testApi) {
		return new ResponseEntity<>(bookService.updateTest(), HttpStatus.OK);

	}

//	public TestApi addBook(@RequestBody TestApi testApi) {
//
//		TestApi b = this.bookService.addTest(testApi);
//		System.out.println(testApi);
//		return b;

//	public user<TestApi> getData() {
//		return new user<>(bookService.CosumerApi(),HttpStatus.OK);
//
//	}

	@GetMapping("/books")
	public List<Book> getBook() {

		return this.bookService.getAllBook();
	}

	@GetMapping("/books/{id}")
	public Book getbookid(@PathVariable("id") int id) {
		return bookService.getBookById(id);

	}

	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {

		Book b = this.bookService.addBook(book);
		System.out.println(book);
		return b;
	}

	@DeleteMapping("/books/{bookid}")
	public void dtlBook(@PathVariable("bookid") int bookid) {
		this.bookService.dltBook(bookid);

	}

	@PutMapping("/books/{bookid}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookid") int bookid) {
		this.bookService.updateBook(book, bookid);

		System.out.println("book upadted :-" + book);
		return book;

	}

}
