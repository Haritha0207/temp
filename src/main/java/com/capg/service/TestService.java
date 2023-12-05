package com.capg.service;

import java.util.List;

import com.capg.entity.Category;
import com.capg.entity.Test;
import com.capg.exceptions.IdNotFoundException;

public interface TestService {
	 public Test addTest(Test test);
	    public Test updateTest(int id,Test test)throws IdNotFoundException; 
	    public List<Test> getAllTests();
	    public  Test getTest(int tId);
	    public  String  deleteTestById(int tId) throws IdNotFoundException; 
		public List<Test> getTestOfCategory(Category cat);
	
}
