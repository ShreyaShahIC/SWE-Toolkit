package oop;

// Week 3: implements the interface without being a Person (a different inheritance chain).
public class UltrasoundScanner implements Contactable {
    private final String scannerId;

    public UltrasoundScanner(String scannerId) {
        this.scannerId = scannerId;
    }

    @Override
    public String contact(String message) {
        return "LOG on scanner " + scannerId + ": " + message;
    }
}
