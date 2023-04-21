package com.example.devtools.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.devtools.Helper.CreateExcelfromDataBase;
import com.example.devtools.Helper.ExcelCreation;
import com.example.devtools.dao.BookRepository;
import com.example.devtools.entities.Book;
import com.example.devtools.entities.TestApi;
import com.example.devtools.entities.entity;

@Component
@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	/*
	 * public static List<Book> list = new ArrayList<>(); static {
	 * 
	 * list.add(new Book(1, "sudhir", "java")); list.add(new Book(2, "sonu",
	 * "python")); list.add(new Book(3, "ankit", "python")); }
	 */

	public List<Book> getAllBook() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		System.out.println(list);
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findById(id);

		}

		catch (Exception e) {
			e.fillInStackTrace();

		}
		return book;

	}

	public Book addBook(Book e) {
		Book result = bookRepository.save(e);
		return result;
	}

	public void dltBook(int bid) {
		/*
		 * list = list.stream().filter(e -> e.getId() !=
		 * bid).collect(Collectors.toList());
		 */
		bookRepository.deleteById(bid);
	}

	public void updateBook(Book book, int bookid) {
		/*
		 * list = list.stream().map(b -> { if (b.getId() == bookid) {
		 * 
		 * b.setName(book.getName()); b.setStatus(book.getStatus()); } return b;
		 * }).collect(Collectors.toList());
		 */
		book.setId(bookid);
		bookRepository.save(book);

	}

	private RestTemplate restTemplate;

	@Autowired
	public BookService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public TestApi CosumerApi() {
		return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", TestApi.class);
	}

	public TestApi[] cosumerApiLsit() {
		return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", TestApi[].class);
	}

	public TestApi AddTest(TestApi test) {

		return restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", test, TestApi.class);

	}

	public String DeleteTest() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		restTemplate.delete("https://jsonplaceholder.typicode.com/posts/101", params);
		return "data has been deleted";
	}

	public String updateTest() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		entity updatedEmployee = new entity(1, 3, "admin123@gmail.com", "sudhir");
		restTemplate.put("https://jsonplaceholder.typicode.com/posts/1", updatedEmployee);
		return "data has been updated";

	}

	public void getActualData() throws IOException {

		List<TestApi> all = Arrays.asList(cosumerApiLsit());
		ExcelCreation.dataToExcel(all);

	}
	
	public List<Book> getData() throws IOException {
//
//		List<TestApi> all = Arrays.asList(cosumerApiLsit());
//		ExcelCreation.dataToExcel(all);
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		System.out.println(list);
		CreateExcelfromDataBase.dataFromDatabase(list);
		return list;
		

	}
	
	
	
	
	
	
	

}
