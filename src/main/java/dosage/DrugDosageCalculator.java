package dosage;

// Tutorial 1 Ex8: takes two objects as parameters; constants instead of magic numbers.
public class DrugDosageCalculator {
    public static final int REDUCTION_START_AGE = 65;
    public static final double REDUCTION_PER_YEAR = 0.02;   // 2% per year over 65

    /** Returns the dose in mg of drug d for patient p. */
    public double calculateDose(Patient p, Drug d) {
        double dose = p.getWeightKg() * d.getDosePerKg();
        int yearsOver = p.getAge() - REDUCTION_START_AGE;
        if (yearsOver > 0) {
            dose = dose * (1 - REDUCTION_PER_YEAR * yearsOver);
        }
        return Math.max(dose, 0);   // never return a negative dose (age 115+)
    }
}
