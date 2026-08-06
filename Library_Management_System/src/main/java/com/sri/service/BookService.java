package com.sri.service;

import java.util.List;

import com.sri.entity.Book;

public interface BookService {

	String addBook(Book b);
	List<Book> getAllBooks();
	Book getBookById(Integer id);
	String updateBookDetails(Integer id,Book b);
	String deleteBook(Integer id);
}
