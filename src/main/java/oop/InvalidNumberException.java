package oop;

// Week 4: custom checked exception with a message.
public class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}
