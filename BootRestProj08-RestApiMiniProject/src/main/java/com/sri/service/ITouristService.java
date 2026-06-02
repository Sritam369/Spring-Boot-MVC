package com.sri.service;

import java.util.List;

import com.sri.vo.TouristVo;

public interface ITouristService {

	String register(TouristVo vo);
	List<TouristVo> findAllTourist();
	String partialUpdate(Integer id,Double hikePercentage);
	String fullUpdate(TouristVo vo);
	String deleteTourist(Integer id);
}
