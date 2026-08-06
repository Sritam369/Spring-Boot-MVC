package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where b.title =?1")
	public List<Book> searchBookByTitle(String title);
    @Query("select b from Book b where b.catagory =?1")
    public List<Book> searchBookByCatagory(String catagory);
    @Query("select b from Book b where b.available=true")
    public List<Book> getAllAvailableBooks();
}
