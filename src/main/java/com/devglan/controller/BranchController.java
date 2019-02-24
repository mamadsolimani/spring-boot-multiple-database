package com.devglan.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devglan.model.dto.AreaDto;
import com.devglan.model.dto.BranchLiteDto;
import com.devglan.service.BranchService;

@Controller
@RequestMapping("/service")
public class BranchController {
	
	public static final Logger log = LoggerFactory.getLogger(BranchController.class);
	
	@Autowired
	private BranchService branchService;

	@RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
	public String test(@PathVariable String name) throws Exception {

		return "hello " + name;
	}
	
	@RequestMapping(value = "/tree/branches", method = RequestMethod.GET)
	public ResponseEntity<List<AreaDto>> findTreeBranches() throws Exception {

		log.debug("Entering findTreeBranches() ");

		List<AreaDto> result = null;
		
		try {
			result = branchService.findTreeBranches();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while calling findTreeBranches().", e);
		}

		return new ResponseEntity<List<AreaDto>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/branches", method = RequestMethod.GET)
	public ResponseEntity<List<BranchLiteDto>> findBranches() throws Exception {

		log.debug("Entering findBranches() ");

		List<BranchLiteDto> result = null;
		
		try {
			result = branchService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while calling findBranches().", e);
		}

		return new ResponseEntity<List<BranchLiteDto>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() throws Exception {

		log.debug("Entering insert() ");
		
		try {
			branchService.insert();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while calling insert().", e);
		}

	}
	
}
