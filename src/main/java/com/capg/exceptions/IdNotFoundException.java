package com.capg.exceptions;

public class IdNotFoundException  extends Exception{
	String msg;
	
	public IdNotFoundException(String msg)
	{
		
		this.msg=msg;
	}
	

	
}
