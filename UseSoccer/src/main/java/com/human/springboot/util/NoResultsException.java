package com.human.springboot.util;

public class NoResultsException extends RuntimeException {
    public NoResultsException(String message) {
        super(message);
    }
}