package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.repository.RailwayRepo;

@Service
@Transactional
public class RailwayServiceImpl implements RailwayService{
	
	@Autowired
	RailwayRepo railwayRepo;
	@Override
	public String addRailway(Railway railway) {
		railwayRepo.save(railway);
		return "Railway Added";
	}

	@Override
	public List<Railway> display() {
		return railwayRepo.findAll();
	}
	
	@Override
	public String deleteRailwayById(Long id) {
		railwayRepo.deleteById(id);
		return "Railway deleted by id";
	}

	@Override
	public void deleteRailwayByName(String name) {
		railwayRepo.deleteAll(railwayRepo.findByName(name));
		
	}

	@Override
	public Railway searchByName(Category category) {
		return railwayRepo.searchByCategory(category);
	}

	@Override
	public List<Railway> sortByName() {
		return railwayRepo.sortByName();
	}

}
