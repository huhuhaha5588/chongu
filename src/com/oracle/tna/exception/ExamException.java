package com.oracle.tna.exception;

public class ExamException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9095055781595949777L;

	public ExamException() {
		super();
	}

	public ExamException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExamException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExamException(String message) {
		super(message);
	}

	public ExamException(Throwable cause) {
		super(cause);
	}
	
	

}
