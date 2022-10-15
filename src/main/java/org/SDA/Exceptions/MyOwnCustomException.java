package org.SDA.Exceptions;

public class MyOwnCustomException extends Exception {
    public MyOwnCustomException() {
        super();
    }

    public MyOwnCustomException(String message) {
        super(message);
    }
}
