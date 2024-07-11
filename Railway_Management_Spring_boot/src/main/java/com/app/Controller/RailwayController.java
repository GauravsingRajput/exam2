package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.service.RailwayService;

@RestController
@RequestMapping("/railway")
public class RailwayController {
	@Autowired
	RailwayService railwayService;

	public RailwayController() {
		System.out.println("In railway constr");
	}

	@PostMapping
	public ResponseEntity<String> addRailway(@RequestBody Railway railway) {
		if (railway != null) {
			railwayService.addRailway(railway);
			return ResponseEntity.status(HttpStatus.OK).body("Railway Inserted");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Railway Can not be added");
	}

	@GetMapping
	public ResponseEntity<List<Railway>> getAllRailways() {
		List<Railway> rlist = railwayService.display();
		return ResponseEntity.status(HttpStatus.OK).body(rlist);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		railwayService.deleteRailwayById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Railway Deleted");
	}

	
	  @DeleteMapping("/delete/{name}") 
	  public ResponseEntity<String> deleteByName(@PathVariable String name){
	  railwayService.deleteRailwayByName(name); 
	  return ResponseEntity.status(HttpStatus.OK).body("Railway Deleted"); }
	 

	@GetMapping("{name}")
	public ResponseEntity<Railway> searchByCategory(String name) {
		Category cat = Category.valueOf(name.toUpperCase());
		Railway rail = railwayService.searchByName(cat);
		return ResponseEntity.status(HttpStatus.OK).body(rail);
	}

	@GetMapping("/sort")
	public ResponseEntity<List<Railway>> sortByName() {
		List<Railway> rlist = railwayService.sortByName();
		return ResponseEntity.status(HttpStatus.OK).body(rlist);
	}
}
