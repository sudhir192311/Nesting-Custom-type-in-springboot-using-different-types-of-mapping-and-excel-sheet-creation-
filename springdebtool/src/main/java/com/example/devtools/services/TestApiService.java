//package com.example.devtools.services;
//
//import java.io.ByteArrayInputStream;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.devtools.Helper.ExcelCreation;
//import com.example.devtools.dao.BookRepository;
//import com.example.devtools.entities.TestApi;
//
//
//
//@Service
//public class TestApiService {
//	@Autowired
//	private BookRepository bookRepository;
//	public ByteArrayInputStream getActualData() {
//		List<TestApi> all=bookRepository.findAll();
//		ByteArrayInputStream byteArrayInputStream = ExcelCreation.dataToExcel(all);
//		return byteArrayInputStream;
//		
//		
//		
//	}
//
//}
