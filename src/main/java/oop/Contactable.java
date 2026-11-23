package oop;

// Week 3: an interface is a contract. Unrelated classes (people, scanners) can all be Contactable.
public interface Contactable {
    /** Sends the message and returns a description of what was sent. */
    String contact(String message);
}
