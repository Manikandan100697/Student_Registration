package com.lti.exception;

public class UserNotFoundException extends Exception {
	public String getMessage() {
		String msg="User not found ";
		return msg;
	}
}
