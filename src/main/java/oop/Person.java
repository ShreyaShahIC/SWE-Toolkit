package oop;

// Week 3: abstract class. Can't be created with new; subclasses must implement contact().
public abstract class Person implements Contactable {
    protected String name;
    protected String contactNum;   // null until a valid number is set

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // contact(String) is NOT written here: Person is abstract,
    // so each concrete subclass must implement Contactable's method.
}
