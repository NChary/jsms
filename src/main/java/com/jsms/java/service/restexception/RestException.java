package com.jsms.java.service.restexception;

public class RestException extends RuntimeException {
	private static final long serialVersionUID = -1278601960490158468L;
	private String code;
	private String message;
	
	public RestException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
