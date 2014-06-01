package com.blogspot.toomuchcoding.book.chapter4.common.exception;

public class InvalidTaxFactorException extends RuntimeException {

    public InvalidTaxFactorException() {
        super();
    }

    public InvalidTaxFactorException(String message) {
        super(message);
    }

}
