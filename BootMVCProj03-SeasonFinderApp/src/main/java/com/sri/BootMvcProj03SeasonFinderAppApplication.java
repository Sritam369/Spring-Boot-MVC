package com.sri;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootMvcProj03SeasonFinderAppApplication {

	@Bean(name="date")
	public LocalDate createDate() {
		return LocalDate.now();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj03SeasonFinderAppApplication.class, args);
	}

}
