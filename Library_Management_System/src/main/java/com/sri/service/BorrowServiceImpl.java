package com.sri.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Book;
import com.sri.entity.BookMember;
import com.sri.entity.BorrowRecord;
import com.sri.exception.BookNotFoundException;
import com.sri.exception.BorrowRecordNotFoundException;
import com.sri.exception.MemberNotFoundException;
import com.sri.repository.BookRepo;
import com.sri.repository.BorrowRecordRepo;
import com.sri.repository.MemberRepo;

import jakarta.transaction.Transactional;

@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	private BorrowRecordRepo repo;
	@Autowired
	private MemberRepo m_repo;
	@Autowired
	private BookRepo b_repo;
	
	
	public String borrowBook(Integer member_id,Integer book_id) {
		BookMember member = m_repo.findById(member_id).orElseThrow(()-> new MemberNotFoundException("Member doesn't exist"));
		Book book = b_repo.findById(book_id).orElseThrow(()-> new BookNotFoundException("Book doesn't exist"));
		Boolean available = book.getAvailable();
		if(available) {
			BorrowRecord b = new BorrowRecord();
			b.setMember(member);
			b.setBook(book);
			b.setBorrow_date(LocalDate.now());
			b.setReturn_date(null);
			b.setStatus("borrowed");
			book.setAvailable(false);
			b_repo.save(book);
			repo.save(b);
			return book_id+" Book is borrowed by "+member_id+" member";
		}
		else {
			return book_id+" Book is already borrowed";
		}
		
	}
	
	
	public String returnBook(Integer borrowId) {
		BorrowRecord record = repo.findById(borrowId).orElseThrow(()->new BorrowRecordNotFoundException("Borrow record doesn't exist"));
		Book byId = b_repo.findById(record.getBook().getBook_id()).orElseThrow(()->new BookNotFoundException("Borrow record doesn't exist"));
		if(record.getReturn_date()==null) {
			record.setReturn_date(LocalDate.now());
			record.setStatus("returned");
			byId.setAvailable(true);
			b_repo.save(byId);
			repo.save(record);
			return "Book with id " + byId.getBook_id() + " returned successfully";
		}
		else {
			return "Book with id " + byId.getBook_id() + " is already returned";
		}
	}
	
	public List<BorrowRecord> getAllRecords(){
		List<BorrowRecord> all = repo.findAll();
		return all;
	}
	
	public BorrowRecord getRecordById(Integer id){
		BorrowRecord byId = repo.findById(id).orElseThrow(()->new BorrowRecordNotFoundException("Borrow record doesn't exist"));
		return byId;
	}
	
	public List<BorrowRecord> getBorrowHistory(Integer member_id){
		BookMember member = m_repo.findById(member_id).orElseThrow(()-> new MemberNotFoundException("Member doesn't exist"));
		List<BorrowRecord> records = member.getRecords();
		return records;
	}
	
	public List<BorrowRecord> getBorrowedBooks(){
		return repo.getAllBorrowedBooks();
	}
	
	public List<BorrowRecord> getReturnedBooks(){
		return repo.getAllReturnedBooks();
	}
	
	public List<BorrowRecord> getBorrowedRecordsByBook(Integer book_id){
		Book byId = b_repo.findById(book_id).orElseThrow(()->new BookNotFoundException("Borrow record doesn't exist"));
		List<BorrowRecord> b_records = byId.getB_records();
		return b_records;
	}
	
	
	public String deleteBorrowRecord(Integer borrowId) {
		BorrowRecord byId = repo.findById(borrowId).orElseThrow(()->new BorrowRecordNotFoundException("Borrow record doesn't exist"));
		if(byId.getStatus().equalsIgnoreCase("returned")) {
			repo.delete(byId);
			return borrowId+" Borrow record deleted successfully";
		}
		else {
			return borrowId+" Borrow record book is not returned";
		}
	}
	
	public String countBorrowedBooks() {
		int count = repo.getAllBorrowedBooks().size();
		
		return "Total "+count+" books has been borrowed";
	}
	
	public String returnedBooks() {
		int count = repo.getAllReturnedBooks().size();
		return "Total "+count+" books has been returned";
	}
}
