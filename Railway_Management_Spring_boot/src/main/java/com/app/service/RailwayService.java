package com.app.service;

import java.util.List;

import com.app.entity.Category;
import com.app.entity.Railway;



public interface RailwayService {
	
	String addRailway(Railway railway);
	
	String deleteRailwayById(Long id);
	
	List<Railway> display();
	
	void deleteRailwayByName(String name);
	
	Railway searchByName(Category category);
	
	List<Railway> sortByName();

}
