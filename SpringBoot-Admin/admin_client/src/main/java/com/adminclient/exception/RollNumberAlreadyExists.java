package com.adminclient.exception;

public class RollNumberAlreadyExists extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RollNumberAlreadyExists(String str) {
		super(str);
	}
}
