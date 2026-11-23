package dosage;

import java.util.ArrayList;

// Tutorial 1 Ex8: three classes plus a driver. Doses fall 2% per year over 65 (read as 2% of the full dose per year).
public class DosageDemo {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("John Barking", 65, 60));
        patients.add(new Patient("Samantha Olives", 65, 70));
        patients.add(new Patient("Paul Ball", 90, 45));

        ArrayList<Drug> drugs = new ArrayList<>();
        drugs.add(new Drug("Paracetamol", 10));
        drugs.add(new Drug("Benadryl", 5));

        DrugDosageCalculator calc = new DrugDosageCalculator();
        for (Patient p : patients) {
            for (Drug d : drugs) {
                System.out.printf("%s: %s %.1f mg%n", p.getName(), d.getName(), calc.calculateDose(p, d));
            }
        }
    }
}
