package com.oracle.tna.exception;

public class AdminUserException extends Exception {

	private static final long serialVersionUID = 2970625183016915662L;

	public AdminUserException(Exception e) {
        super(e);
    }
    public AdminUserException(String msg) {
        super(msg);
    }
}
