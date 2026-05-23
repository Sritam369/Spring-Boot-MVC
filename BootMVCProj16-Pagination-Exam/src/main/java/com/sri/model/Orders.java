package com.sri.model;

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
@Table(name="order_exam_mvc")
@NoArgsConstructor
@RequiredArgsConstructor
public class Orders {

	@Id
	@SequenceGenerator(name="gen1", initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private Double price;
}
