package com.sri.service;

import java.util.List;

import com.sri.dto.BookMemberDTO;
import com.sri.entity.Book;
import com.sri.entity.BookMember;
import com.sri.entity.BorrowRecord;

public interface MemberService {

	String registerMember(BookMember m);
	String updateMember(Integer id,BookMember m);
	String deleteMember(Integer id);
	BookMember getMemberById(Integer id);
	List<BookMember> getAllMembers();
	BookMember searchByName(String name);
	BookMember searchByMail(String mail);
	String totalMembers();
	List<BookMember> activeMembers();
	List<BookMember> inactiveMembers();
	List<BorrowRecord> borrowHistory(Integer memberId);
	List<Book> currentBorrowedBooks(Integer memberId);
	String totalBookCount(Integer id);
	String borrowEligibility(Integer id);
	BookMemberDTO getDetails(Integer id);
	BookMember topReader();
}
