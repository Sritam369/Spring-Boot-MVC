package com.sri.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.dto.BookMemberDTO;
import com.sri.entity.Book;
import com.sri.entity.BookMember;
import com.sri.entity.BorrowRecord;
import com.sri.exception.MemberNotFoundException;
import com.sri.repository.MemberRepo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepo repo;
	
	@Override
	public String registerMember(BookMember m) {
		
		BookMember save = repo.save(m);
		return "Member saved with id "+save.getMember_id();
	}

	@Override
	public String updateMember(Integer id, BookMember m) {
		
		BookMember member = repo.findById(id).orElseThrow(()-> new MemberNotFoundException("Inavlid member id"));
		
		member.setAddress(m.getAddress());
		member.setEmail(m.getEmail());
		member.setName(m.getName());
		member.setPhone(m.getPhone());
		
		repo.save(member);
		return id+" member updated successfully";
	}

	@Override
	public String deleteMember(Integer id) {
		
		BookMember member = repo.findById(id).orElseThrow(()-> new MemberNotFoundException("Inavlid member id"));
		repo.delete(member);
		return member.getMember_id()+" member deleted successfully";
	}

	@Override
	public BookMember getMemberById(Integer id) {
		
		BookMember member = repo.findById(id).orElseThrow(()-> new MemberNotFoundException("Inavlid member id"));
		return member;
	}

	@Override
	public List<BookMember> getAllMembers() {
		return repo.findAll();
	}

	@Override
	public BookMember searchByName(String name) {
		BookMember searchByName = repo.searchByName(name);
		return searchByName;
	}
	
	@Override
	public BookMember searchByMail(String mail) {
		BookMember searchByMail = repo.searchByMail(mail);
		return searchByMail;
	}

	@Override
	public String totalMembers() {
		long count = repo.count();
		return "Total "+count+" members are present";
	}

	@Override
	public List<BookMember> activeMembers() {
		List<BookMember> list = new ArrayList<>();
		
		List<BookMember> all = repo.findAll();
		
		for(BookMember b:all) {
			List<BorrowRecord> records = b.getRecords();
			for(BorrowRecord br:records) {
				if(br.getStatus().equalsIgnoreCase("borrowed")) {
					list.add(b);
					break;
				}
			}
		}
		return list;
	}
	
	@Override
	public List<BookMember> inactiveMembers() {

	    List<BookMember> list = new ArrayList<>();

	    for (BookMember member : repo.findAll()) {
	        if (member.getRecords().isEmpty()) {
	            list.add(member);
	        }
	    }

	    return list;
	}

	@Override
	public List<BorrowRecord> borrowHistory(Integer id) {
		BookMember member = repo.findById(id).orElseThrow(()-> new MemberNotFoundException("Inavlid member id"));		
		return member.getRecords();
	}

	@Override
	public List<Book> currentBorrowedBooks(Integer id) {
		BookMember member = repo.findById(id).orElseThrow(()-> new MemberNotFoundException("Inavlid member id"));		
		List<BorrowRecord> records = member.getRecords();
		
		List<Book> list = new ArrayList<>();
		for(BorrowRecord b:records) {
			if(b.getStatus().equalsIgnoreCase("borrowed")) {
				list.add(b.getBook());
			}
		}
		return list;
	}

	@Override
	public String totalBookCount(Integer id) {
		BookMember member = repo.findById(id).orElseThrow(()-> new MemberNotFoundException("Inavlid member id"));		
		List<BorrowRecord> records = member.getRecords();
		
		int c = 0;
		for(BorrowRecord b:records) {
			if(b.getStatus().equalsIgnoreCase("borrowed")) {
				c++;
			}
		}
		return "Borrowed : "+c;
	}

	@Override
	public String borrowEligibility(Integer id) {
		BookMember member = repo.findById(id).orElseThrow(()-> new MemberNotFoundException("Inavlid member id"));		
		List<BorrowRecord> records = member.getRecords();
		
		int c = 0;
		for(BorrowRecord b:records) {
			if(b.getStatus().equalsIgnoreCase("borrowed")) {
				c++;
			}
		}
		if(c<3) {
			return member+" is eligible to borrow books";
		}
		else {
			return member+" is not eligible to borrow books";
		}
	}

	@Override
	public BookMemberDTO getDetails(Integer id) {
		BookMember member = repo.findById(id).orElseThrow(()-> new MemberNotFoundException("Inavlid member id"));
		
		List<Book> borrow = new ArrayList<>();
		List<Book> returned = new ArrayList<>();
		LocalDate lastBorrowDate = null;
		List<BorrowRecord> records = member.getRecords();
		for(BorrowRecord b:records) {
			if(b.getStatus().equalsIgnoreCase("borrowed")) {
				borrow.add(b.getBook());
			}
			else {
				returned.add(b.getBook());
			}
			if (lastBorrowDate == null || b.getBorrow_date().isAfter(lastBorrowDate)) {
			        lastBorrowDate = b.getBorrow_date();
			}
		}
		BookMemberDTO dto = new BookMemberDTO(borrow,returned,lastBorrowDate);
		
		return dto;
	}

	@Override
	public BookMember topReader() {
		List<BookMember> all = repo.findAll();
		
		Long maxCount = 0l;
		BookMember topReader = null;
		
		for(BookMember m:all) {
			long count = m.getRecords().stream().filter(e->e.getStatus().equalsIgnoreCase("borrowed")).count();
			
			if(count>maxCount) {
				maxCount=count;
				topReader = m;
			}
		}
		
		return topReader;
	}

}
