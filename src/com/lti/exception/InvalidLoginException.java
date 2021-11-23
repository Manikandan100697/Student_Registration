package com.lti.exception;

public class InvalidLoginException extends Exception {
	public String getMessage() {
		String msg="No such user exists ! Verify UserID again ";
		return msg;
	}

}
