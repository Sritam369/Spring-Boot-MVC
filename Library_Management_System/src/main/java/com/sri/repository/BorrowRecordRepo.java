package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.BorrowRecord;


public interface BorrowRecordRepo extends JpaRepository<BorrowRecord, Integer> {
	
	@Query(value="select * from borrow_record_proj  where status='borrowed' ",nativeQuery=true)
	public List<BorrowRecord> getAllBorrowedBooks();
	@Query(value="select * from borrow_record_proj  where status='returned' ",nativeQuery=true)
	public List<BorrowRecord> getAllReturnedBooks();
}
