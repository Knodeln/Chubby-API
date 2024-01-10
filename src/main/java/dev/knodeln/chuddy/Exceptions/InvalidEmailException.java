package dev.knodeln.chuddy.Exceptions;

public class InvalidEmailException extends Exception{

    public InvalidEmailException(String message) {
        super(message);
    }

    public InvalidEmailException() {
    }

}
