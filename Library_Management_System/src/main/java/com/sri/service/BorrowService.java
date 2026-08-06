package com.sri.service;

import java.util.List;

import com.sri.entity.BorrowRecord;

public interface BorrowService {

	String borrowBook(Integer member_id,Integer book_id);
	String returnBook(Integer borrowId);
	List<BorrowRecord> getAllRecords();
	BorrowRecord getRecordById(Integer id);
	List<BorrowRecord> getBorrowHistory(Integer member_id);
	List<BorrowRecord> getBorrowedBooks();
	List<BorrowRecord> getReturnedBooks();
	List<BorrowRecord> getBorrowedRecordsByBook(Integer book_id);
	String deleteBorrowRecord(Integer borrowId);
	String countBorrowedBooks();
	String returnedBooks();
}

