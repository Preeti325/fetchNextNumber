package com.preeti.controller;

import java.util.Map;

import com.preeti.dao.INumberDAO;
import com.preeti.entity.NumberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.preeti.service.INumberService;

@RestController
public class Controller {
	
	@Autowired
	private INumberService service;

	@Autowired
	INumberDAO iNumberDAO;


	@PutMapping("/FetchNextNumber")
	public Map<String,Integer> update(@RequestBody Map<String,String> thecategoryCode){
		String categoryCode = thecategoryCode.get("categoryCode");
		return this.service.updateMyNumber(categoryCode);
	}

	@PostMapping("/create")
	public ResponseEntity<NumberEntity> create(@RequestBody NumberEntity numberEntity) {
		NumberEntity numberEntity1 = iNumberDAO.save(new NumberEntity(numberEntity.getCategoryCode(), numberEntity.getValue()));
		return new ResponseEntity<>(numberEntity1, HttpStatus.CREATED);
	}
	
}
