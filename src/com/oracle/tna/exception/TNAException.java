package com.oracle.tna.exception;

public class TNAException extends Exception
{
	private static final long serialVersionUID = -1294175355832296634L;
	
	public TNAException(Exception exception )
	{
		super(exception);
	}
	public TNAException(String mes)
	{
		super(mes);
	}
}
