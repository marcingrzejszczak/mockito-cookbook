package com.blogspot.toomuchcoding.book.chapter5.exception;

public class UndefinedCountryException extends RuntimeException {

	public UndefinedCountryException() {
		super();
	}

	public UndefinedCountryException(String msg) {
		super(msg);
	}
}
