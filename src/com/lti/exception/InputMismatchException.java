package com.lti.exception;

public class InputMismatchException extends Exception{
	public String getMessage() {
		String msg="Input error, Please enter valid number";
		return msg;
	}

}