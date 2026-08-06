package com.sri.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="borrow_record_proj")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowRecord {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "s1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer borrow_id;
	
	private LocalDate borrow_date;
	
	private LocalDate return_date;
	@NonNull
	private String status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", referencedColumnName = "member_id")
	@JsonBackReference(value = "member-borrow")
	private BookMember member;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", referencedColumnName = "book_id")
	@JsonBackReference(value = "book-borrow")
	private Book book;
}
