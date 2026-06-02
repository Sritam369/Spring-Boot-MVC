package com.sri.model;

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
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="tourist_entity")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Tourist {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "t1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String city;
	@NonNull
	private String packageType;
	@NonNull
	private Double budget;
}
