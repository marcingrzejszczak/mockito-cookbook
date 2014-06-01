package com.blogspot.toomuchcoding.book.chapter6._8_VerifyingWithTimeout;

public class FailedToSavedPersonDataException extends RuntimeException {
    public FailedToSavedPersonDataException(String message) {
        super(message);
    }
}
