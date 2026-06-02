package com.sri.vo;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class TouristVo {
	@Id
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
