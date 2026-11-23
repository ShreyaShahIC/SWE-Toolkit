package errors;

// Week 4: a checked exception (extends Exception, so callers must catch it or declare throws).

public class ScanException extends Exception {
    public ScanException(String message) {
        super(message);
    }
}
