package oop;

// Weeks 2-3: subclass with super(), a static id counter, a validated setter throwing a checked exception, and an override.
public class Patient extends Person {
    private static int nextId = 1;   // class field: shared by all Patients
    private final int id;

    public Patient(String name) {
        super(name);                  // must be the first line
        id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public void setMobileNum(String mobileNum) throws InvalidNumberException {
        if (mobileNum == null || !mobileNum.matches("07\\d{9}")) {
            throw new InvalidNumberException("Invalid mobile number: " + mobileNum);
        }
        contactNum = mobileNum;
    }

    public String getMobileNum() {
        return contactNum;
    }

    @Override
    public String contact(String message) {
        if (contactNum == null) {
            throw new IllegalStateException(name + " has no mobile number");
        }
        return "TEXT to " + contactNum + ": " + message;
    }
}
