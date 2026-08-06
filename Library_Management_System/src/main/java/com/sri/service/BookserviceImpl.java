package com.sri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Book;
import com.sri.exception.BookNotFoundException;
import com.sri.repository.BookRepo;

@Service
public class BookserviceImpl implements BookService {

	@Autowired
	private BookRepo book_repo;
	
	public String addBook(Book b) {
		Book save = book_repo.save(b);
		return "Book added with id : "+save.getBook_id();
	}
	
	public List<Book> getAllBooks(){
		List<Book> all = book_repo.findAll();
		return all;
	}
	
	public Book getBookById(Integer id) { 
		Book book = book_repo.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found"));
		return book;
	}
	
	public String updateBookDetails(Integer id, Book b) {
		Book book = book_repo.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found"));
		book.setAuthor(b.getAuthor());
		book.setTitle(b.getTitle());
		book.setAvailable(b.getAvailable());
		book_repo.save(book);
		
		return "Book with id : "+book.getBook_id()+" updated successfully";
	}
	
	public String deleteBook(Integer id) {
		Book book = book_repo.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found"));
		book_repo.delete(book);
		return "Book with id "+id+" deleted successfully";
	}
}
