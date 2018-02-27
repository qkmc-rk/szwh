package com.szwh.dao;

public class CaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaseException() {
		super();
	}

	public CaseException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CaseException(String arg0) {
		super(arg0);
	}

	public CaseException(Throwable arg0) {
		super(arg0);
	}
	
	
	
}
