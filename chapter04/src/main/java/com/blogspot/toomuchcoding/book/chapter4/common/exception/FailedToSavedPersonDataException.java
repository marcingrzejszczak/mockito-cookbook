package com.blogspot.toomuchcoding.book.chapter4.common.exception;

public class FailedToSavedPersonDataException extends RuntimeException {
    public FailedToSavedPersonDataException(String message) {
        super(message);
    }
}
