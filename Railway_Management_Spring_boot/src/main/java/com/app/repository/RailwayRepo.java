package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Category;
import com.app.entity.Railway;

@Repository
public interface RailwayRepo extends JpaRepository<Railway,Long>{

	List<Railway> findByName(String name);
	
	@Query("select r from Railway r where r.category=:cat")
	Railway searchByCategory(Category cat);
	
	@Query("select r from Railway r order by r.name")
	List<Railway> sortByName();

}
