package com.oracle.tna.exception;

public class LoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 536779658041109910L;
	
	public LoginException(Exception e) {
        super(e);
    }
    public LoginException(String msg) {
        super(msg);
    }
}
