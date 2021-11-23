package com.lti.exception;

public class ClassNotFoundException extends Exception {
	public String getMessage() {
		String msg="No such class found exception ";
		return msg;
	}

}
