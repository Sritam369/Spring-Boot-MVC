package com.sri.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.exception.TouristNotFoundException;
import com.sri.model.Tourist;
import com.sri.repository.TouristRepo;
import com.sri.vo.TouristVo;

@Service
public class TouristServiceImpl implements ITouristService{

	@Autowired
	private TouristRepo repo;

	@Override
	public String register(TouristVo vo) {
		Tourist t = new Tourist();
		BeanUtils.copyProperties(vo, t);
		Tourist save = repo.save(t);
		return "Tourist added successfully with id : "+save.getId();
	}

	@Override
	public List<TouristVo> findAllTourist() {
		List<Tourist> all = repo.findAll();
		List<TouristVo> vos = new ArrayList<>();
		all.forEach(t->{
			TouristVo vo = new TouristVo();
			BeanUtils.copyProperties(t,vo);
			vos.add(vo);
		});
		return vos;
	}
	
	@Override
	public String partialUpdate(Integer id,Double hikePercentage) {
		Tourist t = repo.findById(id).orElseThrow(()->new TouristNotFoundException("Invalid id"));
		t.setBudget(t.getBudget()+t.getBudget()*hikePercentage/100);
		Tourist save = repo.save(t);
		return save.getId()+" Tourist budget updated";
	}

	@Override
	public String fullUpdate(TouristVo vo) {
		Tourist t = new Tourist();
		BeanUtils.copyProperties(vo, t);
		Tourist update = repo.save(t); 
		return update.getId()+" Tourist details updated";
	}

	@Override
	public String deleteTourist(Integer id) {
		Tourist orElseThrow = repo.findById(id).orElseThrow(()->new TouristNotFoundException("Invalid id"));
		repo.delete(orElseThrow);
		return orElseThrow.getId()+" Tourist record deleted";
	}
	
	
}
