package oop;

// Weeks 2-3: second subclass of Person with its own contact() override.
public class Doctor extends Person {

    public Doctor(String name) {
        super(name);
    }

    public void setPagerNum(String pagerNum) throws InvalidNumberException {
        if (pagerNum == null || !pagerNum.matches("\\d{4}")) {
            throw new InvalidNumberException("Pager numbers have 4 digits: " + pagerNum);
        }
        contactNum = pagerNum;
    }

    public String getPagerNum() {
        return contactNum;
    }

    @Override
    public String contact(String message) {
        if (contactNum == null) {
            throw new IllegalStateException(name + " has no pager number");
        }
        return "PAGE " + contactNum + ": " + message;
    }
}
