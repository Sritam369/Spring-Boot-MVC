package com.sri.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "emp_retrieve")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "s1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer emp_id;
	@NonNull
	private String emp_name;
	@NonNull
	private String department;
	@NonNull
	private Double salary;
	@NonNull
	private String email;
}
