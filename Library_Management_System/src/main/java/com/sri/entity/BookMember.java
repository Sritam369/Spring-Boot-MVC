package com.sri.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="member_proj")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookMember {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "s1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer member_id;
	@NonNull
	private String name;
	@NonNull
	private String email;
	@NonNull
	private String phone;
	@NonNull
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="member")
	@JsonManagedReference(value = "member-borrow")
	private List<BorrowRecord> records;
	
}
