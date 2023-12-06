package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Category;
import com.capg.entity.Test;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repo.CategoryRepository;
import com.capg.repo.TestRepo;
import com.capg.util.AppConstants;

@Service
public class TestServiceimpl implements TestService{

	@Autowired
	TestRepo testRepo;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public Test addTest(Test test) {
		
		Category category=null;
		System.out.println(test.getCategory());
		int category_id = test.getCategory().getCategoryId();
		if(categoryRepository.existsById(category_id)) {
			category = categoryRepository.findById(category_id).get();
			System.out.println("Fetching Category: \n"+category);
			test.setCategory(category);
		}
		return testRepo.save(test);	
	}


	public Test updateTest(int tId, Test test) throws IdNotFoundException {
		
		if(testRepo.existsById(tId))
		{
//			updateTest=testRepo.findById(tId).get();
			test.settId(tId);
			return testRepo.save(test);
		}
		else
		{
			throw new IdNotFoundException(AppConstants.TEST_ID_NOT_FOUND_INFO);
		}
		
	}

	
	public List<Test> getAllTests() {
		// TODO Auto-generated method stub
		return testRepo.findAll();
	}

	public Test getTest(int tId) {
		// TODO Auto-generated method stub
		return testRepo.findById(tId).get();
	}

	public String deleteTestById(int tId) throws IdNotFoundException{
		String msg;
		if(testRepo.existsById(tId))
		{
			testRepo.deleteById(tId);
			msg="Id deleted successfully";
		}
		else
		{
			throw new IdNotFoundException(AppConstants.TEST_ID_NOT_FOUND_INFO);
		}
		
		return msg;
	}

	
	public List<Test> getTestOfCategory(Category category) {
		// TODO Auto-generated method stub
		return testRepo.findByCategory(category);
	}
	
	
}
