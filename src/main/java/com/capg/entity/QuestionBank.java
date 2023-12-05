package com.capg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="questionbank")
public class QuestionBank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="questionbank_Id")
	private int qbId;
	@Column(name="questionbank_Name")
	private String qbName;
//private Category category;
	public QuestionBank(int qbId, String qbName) {
		this.qbId = qbId;
		this.qbName = qbName;
//		this.category = category;
	}
	public QuestionBank()
	{
		
	}
	public int getQbId() {
		return qbId;
	}
	public void setQbId(int qbId) {
		this.qbId = qbId;
	}
	public String getQbName() {
		return qbName;
	}
	public void setQbName(String qbName) {
		this.qbName = qbName;
	}
//	public Category getCategory() {
//		return category;
//	}
//	public void setCategory(Category category) {
//		this.category = category;
//	}
	@Override
	public String toString() {
		return "QuestionBank [qbId=" + qbId + ", qbName=" + qbName + "]";
	}
}
