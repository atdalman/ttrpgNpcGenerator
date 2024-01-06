package com.ttrpg.quadraticwiz.exceptions;

public class SystemNotSupportedException extends RuntimeException {
    public SystemNotSupportedException(String message) {
        super(message + " is currently not supported.");
    }
}
