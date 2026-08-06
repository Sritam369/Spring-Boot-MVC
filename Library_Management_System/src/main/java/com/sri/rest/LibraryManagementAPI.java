package com.sri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.dto.BookMemberDTO;
import com.sri.entity.Book;
import com.sri.entity.BookMember;
import com.sri.entity.BorrowRecord;
import com.sri.service.BookService;
import com.sri.service.BorrowService;
import com.sri.service.MemberService;

@RestController
@RequestMapping("/library")
public class LibraryManagementAPI {

	@Autowired
	private BookService bookService;
	@Autowired
	private BorrowService borrowService;
	@Autowired
	private MemberService memberService;
	
	// Book service endpoints
	
	@PostMapping("/add")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		String msg = bookService.addBook(book);
		
		return  ResponseEntity.ok(msg);
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> allBooks = bookService.getAllBooks();
		
		return ResponseEntity.ok(allBooks);
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable(name="id")Integer id){
		Book book = bookService.getBookById(id);
		
		return ResponseEntity.ok(book);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateBook(@PathVariable Integer id,@RequestBody Book b){
		String updateBookDetails = bookService.updateBookDetails(id, b);
		
		return ResponseEntity.ok(updateBookDetails);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer id){
		String delete = bookService.deleteBook(id);
		
		return ResponseEntity.ok(delete);
	}
	
	// Borrow service endpoints
	
	@PostMapping("/borrow/{memberId}/{bookId}")
	public ResponseEntity<String> borrowBook(@PathVariable Integer memberId,@PathVariable Integer bookId){
		
		String borrowBook = borrowService.borrowBook(memberId, bookId);
		return ResponseEntity.ok(borrowBook);
	}
	
	@PutMapping("/return/{borrowId}")
	public ResponseEntity<String> returnBook(@PathVariable Integer borrowId){
		String returnBook = borrowService.returnBook(borrowId);
		return ResponseEntity.ok(returnBook);
	}
	
	@GetMapping("/borrowRecords")
	public ResponseEntity<List<BorrowRecord>> getAllRecords(){
		return ResponseEntity.ok(borrowService.getAllRecords());
	}
	
	@GetMapping("/borrowRecordById/{id}")
	public ResponseEntity<BorrowRecord> getRecordById(@PathVariable Integer id){
		return ResponseEntity.ok(borrowService.getRecordById(id));
	}
	
	@GetMapping("/borrowHistory/{memberId}")
	public ResponseEntity<List<BorrowRecord>> getBorrowHistory(@PathVariable Integer memberId){
		return ResponseEntity.ok(borrowService.getBorrowHistory(memberId));
	}
	
	@GetMapping("/borrowedBooks")
	public ResponseEntity<List<BorrowRecord>> getBorrowedBooks(){
		return ResponseEntity.ok(borrowService.getBorrowedBooks());
	}
	
	@GetMapping("/returnedBooks")
	public ResponseEntity<List<BorrowRecord>> getReturnedBooks(){
		return ResponseEntity.ok(borrowService.getReturnedBooks());
	}
	
	@GetMapping("/borrowRecordByBook/{bookId}")
	public ResponseEntity<List<BorrowRecord>> getBorrowRecordByBook(@PathVariable Integer bookId){
		return ResponseEntity.ok(borrowService.getBorrowedRecordsByBook(bookId));
	}
	
	@DeleteMapping("/deleteBorrowRecord/{borrowId}")
	public ResponseEntity<String> deleteBorrowRecord(@PathVariable Integer borrowId){
		return ResponseEntity.ok(borrowService.deleteBorrowRecord(borrowId));
	}
	
	@GetMapping("/count")
	public ResponseEntity<String> countBorrowedBooks(){
		return ResponseEntity.ok(borrowService.countBorrowedBooks());
	}
	
	@GetMapping("/returnedBooksCount")
	public ResponseEntity<String> returnedBooks(){
		return ResponseEntity.ok(borrowService.returnedBooks());
	}
	
	// Member service endpoints
	
	@PostMapping("/registerMember")
	public ResponseEntity<String> registerMember(@RequestBody BookMember member){
		return ResponseEntity.ok(memberService.registerMember(member));
	}
	
	@PutMapping("/updateMember/{id}")
	public ResponseEntity<String> updateMember(@PathVariable Integer id,@RequestBody BookMember member){
		return ResponseEntity.ok(memberService.updateMember(id,member));
	}
	
	@DeleteMapping("/deleteMember/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable Integer id){
		return ResponseEntity.ok(memberService.deleteMember(id));
	}
	
	@GetMapping("/getMemberById/{id}")
	public ResponseEntity<BookMember> getMemberById(@PathVariable Integer id){
		return ResponseEntity.ok(memberService.getMemberById(id));
	}
	
	@GetMapping("/getAllMembers")
	public ResponseEntity<List<BookMember>> getAllMembers(){
		return ResponseEntity.ok(memberService.getAllMembers());
	}
	
	@GetMapping("/searchByName/{name}")
	public ResponseEntity<BookMember> searchByName(@PathVariable String name){
		return ResponseEntity.ok(memberService.searchByName(name));
	}
	
	@GetMapping("/searchByMail/{mail}")
	public ResponseEntity<BookMember> searchByMail(@PathVariable String mail){
		return ResponseEntity.ok(memberService.searchByMail(mail));
	}
	
	@GetMapping("/total")
	public ResponseEntity<String> totalMembers(){
		return ResponseEntity.ok(memberService.totalMembers());
	}
	
	@GetMapping("/active")
	public ResponseEntity<List<BookMember>> activeMembers(){
		return ResponseEntity.ok(memberService.activeMembers());
	}
	
	@GetMapping("/inactive")
	public ResponseEntity<List<BookMember>> inactiveMembers(){
		return ResponseEntity.ok(memberService.inactiveMembers());
	}
	
	@GetMapping("/history/{memberId}")
	public ResponseEntity<List<BorrowRecord>> borrowHistory(@PathVariable Integer memberId){
		return ResponseEntity.ok(memberService.borrowHistory(memberId));
	}
	
	@GetMapping("/currentBorrowedBooks/{memberId}")
	public ResponseEntity<List<Book>> currentBorrowedBooks(@PathVariable Integer memberId){
		return ResponseEntity.ok(memberService.currentBorrowedBooks(memberId));
	}
	
	@GetMapping("/totalBookCount/{memberId}")
	public ResponseEntity<String> totalBookCount(@PathVariable Integer memberId){
		return ResponseEntity.ok(memberService.totalBookCount(memberId));
	}
	
	@GetMapping("/borrowEligibility/{memberId}")
	public ResponseEntity<String> borrowEligibility(@PathVariable Integer memberId){
		return ResponseEntity.ok(memberService.borrowEligibility(memberId));
	}
	
	@GetMapping("/details/{memberId}")
	public ResponseEntity<BookMemberDTO> getDetails(@PathVariable Integer memberId){
		return ResponseEntity.ok(memberService.getDetails(memberId));
	}
	
	@GetMapping("/top")
	public ResponseEntity<BookMember> topReader(){
		return ResponseEntity.ok(memberService.topReader());
	}
	
}
