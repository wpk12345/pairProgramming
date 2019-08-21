package com.cognizantbootcamp.personservice.exception;

public class NotFoundException extends RuntimeException {
    /**
     * Exception class to handle not found cases in get APIs
     */
        public NotFoundException() {
        }
        public NotFoundException(String message) {
            super(message);
        }
}
