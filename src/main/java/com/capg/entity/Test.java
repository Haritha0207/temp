package com.capg.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="test")
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_id")
	private int tId;
	
	@Column(name="test_name")
	private String tName;
	
	@Column(name="no_of_questions")
	private int noOfQuestions;
	
	@Column(name="max_Marks")
	private int maxMarks;
	
	private boolean isActive=true;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="category_id", referencedColumnName = "category_id")
	@JsonBackReference(value = "category_id")
	private Category category;
	
	/*public List<Question> getQuestions() {
	    return questions;
	}
	public void setQuestions(List<Question> questions) {
	    this.questions = questions;
	}
	
	@OneToMany(mappedBy = "test",cascade = CascadeType.ALL)
	private List<Question> questions= new ArrayList<>();
	*/
	
	public Test()
	{
		
	}
	public Test(int tId, String tName, int noOfQuestions, int maxMarks, boolean isActive, Category category) {
		this.tId = tId;
		this.tName = tName;
		this.noOfQuestions = noOfQuestions;
		this.maxMarks = maxMarks;
		this.isActive = isActive;
		this.category = category;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public int getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public int getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Test [tId=" + tId + ", tName=" + tName + ", noOfQuestions=" + noOfQuestions + ", maxMarks=" + maxMarks
				+ ", isActive=" + isActive + ", category=" + category.getCategoryId() + "]";
	}
}
