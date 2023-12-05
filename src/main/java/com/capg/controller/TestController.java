package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Category;
import com.capg.entity.Test;
import com.capg.exceptions.IdNotFoundException;
import com.capg.service.TestService;

@RestController
@RequestMapping("/api/v1")
public class TestController {

	    @Autowired
	    private TestService testService;

	    //add test
	    @PostMapping("/addtest")
		public ResponseEntity<Test> addTest(@RequestBody Test test)
		{
			return new ResponseEntity <Test>(testService.addTest(test), HttpStatus.OK);
		}
	    //update test
	    @PutMapping("/update/{test_id}")
	    public ResponseEntity<Test> updateTestById(@PathVariable("test_id") int id,@RequestBody Test test) throws IdNotFoundException
		{
			return new ResponseEntity<Test>(testService.updateTest(id,test), HttpStatus.OK);
		}
	    //get test
	    @GetMapping("/alltests")
	    public ResponseEntity<List<Test>> getAllTests()
		{
			return new ResponseEntity <List<Test>>(testService.getAllTests(),HttpStatus.OK);
		}

	    //get single test	
	    @GetMapping("/test/{test_id}")
	    public ResponseEntity<Test> getTest(@PathVariable("test_id") Integer tId)
		{
			return new ResponseEntity<Test>(testService.getTest(tId), HttpStatus.OK);
		}
	    
	    //delete test
	    @DeleteMapping("/deletetest/{test_id}")
	    public ResponseEntity<String> deleteTestById(@PathVariable("test_id") int tId) throws IdNotFoundException
		{
			return new ResponseEntity<String>(testService.deleteTestById(tId), HttpStatus.OK);
		}
	   
	    //get test of particular category
	    @GetMapping("/category/{category_id}")
		public ResponseEntity<List<Test>> getTestOfCategory(@PathVariable Category category)
		{
			return new ResponseEntity<List<Test>>(testService.getTestOfCategory(category), HttpStatus.OK);
		}
}
