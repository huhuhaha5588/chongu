package com.oracle.tna.exception;

public class AdminUserLoginException extends Exception {

	private static final long serialVersionUID = 2970625183016915662L;

	public AdminUserLoginException(Exception e) {
        super(e);
    }
    public AdminUserLoginException(String msg) {
        super(msg);
    }
}
