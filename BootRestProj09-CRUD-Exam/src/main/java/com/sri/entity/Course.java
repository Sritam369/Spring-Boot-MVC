package com.sri.entity;

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

@Entity
@Data
@Table(name="course-exam")
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "s1",allocationSize = 1,initialValue = 100)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer courseId;
	@NonNull
	private String courseName;
	@NonNull
	private String trainerName;
	@NonNull
	private String duration;
	@NonNull
	private Double fee;
}
