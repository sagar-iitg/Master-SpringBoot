package com.example.demo.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


import com.example.demo.entities.Book;

@Component
//interacting with dao layer
public class BookService {

    private static List<Book> list=new ArrayList<>();
    
    static {
    	
    	list.add(new Book(1,"python"));
    	list.add(new Book(2,"java"));
    	list.add(new Book(3,"javascript"));
    	list.add(new Book(4,"C++"));
    }
    
    public List<Book> getAllBooks(){
    	return list;
    }
    
    public Book getSingleBookByID(int id){
    	
    	//reference variable
    	Book b=null;
    	for (Book book : list) {
    		if(book.getId()==id)
    			b=book;
			
		}
    	return b;
    	
    	
    }


	//adding the book
	public void addBook(Book b){
    	
    	//reference variable
    	list.add(b);
    	
    }
	//delete by id
	public void deleteByID(int id){

	
    	list=list.stream().filter(book->book.getId()!=id)
		.collect(Collectors.toList());


	}
    
	//update by id
	public void updateBook(Book book,int id)
	{

	

    	list=list.stream().map(b->{
				if(b.getId()==id){

					b.setName(book.getName());
				}

			return b;
		}).collect(Collectors.toList());


	}

    
    
}
