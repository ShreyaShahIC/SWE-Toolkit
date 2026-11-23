package dosage;

// Tutorial 1 Ex8: a simple data class.
public class Drug {
    private final String name;
    private final double dosePerKg;   // mg per kg of body weight

    public Drug(String name, double dosePerKg) {
        this.name = name;
        this.dosePerKg = dosePerKg;
    }

    public String getName() { return name; }
    public double getDosePerKg() { return dosePerKg; }
}
