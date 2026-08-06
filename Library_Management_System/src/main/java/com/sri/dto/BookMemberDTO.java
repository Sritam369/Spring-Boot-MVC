package com.sri.dto;

import java.time.LocalDate;
import java.util.List;

import com.sri.entity.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookMemberDTO {

	private List<Book> borrowedBooks;
	private List<Book> returnedBooks;
	private LocalDate lastBorrowDate;
}
