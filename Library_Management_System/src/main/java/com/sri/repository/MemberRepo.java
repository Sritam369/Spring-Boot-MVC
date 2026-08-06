package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.BookMember;

public interface MemberRepo extends JpaRepository<BookMember, Integer> {

	@Query("select m from BookMember m where m.name=?1")
	BookMember searchByName(String name);
	
	@Query("select m from BookMember m where m.email=?1")
	BookMember searchByMail(String mail);
}
