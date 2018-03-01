package me.inori.base.exception;

public class MyException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	private String message;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
		

}
