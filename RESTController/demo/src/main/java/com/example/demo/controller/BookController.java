package com.example.demo.controller;

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

import java.util.*;
import com.example.demo.entities.Book;
import com.example.demo.services.BookService;

@RestController
public class BookController {
	
	
	@Autowired
	private BookService bookService;


	@GetMapping("/books")
	public ResponseEntity<List<Book>>getBooks() {
		
		
		
		List<Book> list=bookService.getAllBooks();
		if(list.size()<=0){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));

		
	}

	
	@GetMapping("/books/{id}")
	public Book getBooks(@PathVariable("id") int id) {
		
		
		return this.bookService.getSingleBookByID(id);
	}

		
	
	@PostMapping("/books")
	public Book addBooks(@RequestBody Book b) {
	 	this.bookService.addBook(b);
		return b;
	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
	 	 this.bookService.deleteByID(id);
	    //return b;
	}

	//update book handler

	@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book b,@PathVariable("id") int id )
	{


	 this.bookService.updateBook(b,id);
	 return b;


	}

}
