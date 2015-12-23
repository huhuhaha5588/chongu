package com.oracle.tna.exception;

public class ScoreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7138763621253135544L;

	public ScoreException() {
		super();
	}

	public ScoreException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ScoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScoreException(String message) {
		super(message);
	}

	public ScoreException(Throwable cause) {
		super(cause);
	}

	
}
