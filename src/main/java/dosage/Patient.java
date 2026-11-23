package dosage;

// Tutorial 1 Ex8: encapsulation. Private final fields, getters, and validation in the constructor.
public class Patient {
    private final String name;
    private final double weightKg;
    private final int age;

    public Patient(String name, double weightKg, int age) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.weightKg = weightKg;
        this.age = age;
    }

    public String getName() { return name; }
    public double getWeightKg() { return weightKg; }
    public int getAge() { return age; }
}
