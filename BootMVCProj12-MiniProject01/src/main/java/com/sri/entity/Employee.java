package com.sri.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;

@Entity
@Table(name="employee_mvc")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "mvc1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer empNo;
	@NonNull
	private String empName;
	@NonNull
	private String job;
	@NonNull
	private Double sal;
	@NonNull
	private Integer deptNo;
}
