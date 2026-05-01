package com.sri.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonFinderService implements ISeasonFinder {

	@Autowired
	private LocalDate date;
	@Override
	public String displaySeason() {
		int month = date.getMonthValue();
		if(month>=3 && month<=6) {
			return "Summer Season";
		}
		else if(month>=7 && month<=9) {
			return "Rainy Season";
		}
		else
		return "Winter Season";
	}

}
