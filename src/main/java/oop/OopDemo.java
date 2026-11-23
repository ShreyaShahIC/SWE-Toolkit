package oop;

import java.util.ArrayList;
import java.util.List;

// Weeks 2-3 driver: the four pillars in one place.
public class OopDemo {

    // Ad hoc polymorphism: overloading on parameter types
    static int add(int a, int b) { return a + b; }
    static double add(double a, double b) { return a + b; }
    static String add(String a, String b) { return a + b; }

    public static void main(String[] args) {
        // Encapsulation: fields are private/protected; setters validate (checked exception)
        Patient john = new Patient("John Smith");
        Doctor hugo = new Doctor("Hugo Catfish");
        try {
            john.setMobileNum("07700900123");
            hugo.setPagerNum("4521");
            hugo.setPagerNum("12");                        // invalid -> jumps to catch
        } catch (InvalidNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Subtype polymorphism + abstraction: one list, three different classes
        Hospital hospital = new Hospital();
        hospital.addContact(john);
        hospital.addContact(hugo);
        hospital.addContact(new Patient("No Phone"));
        hospital.addContact(new UltrasoundScanner("US-1"));
        List<String> sent = hospital.broadcast("Visiting time is over");
        for (String s : sent) System.out.println(s);
        System.out.println("Failed: " + hospital.getFailedLastBroadcast());

        // Upcasting is automatic; the object's real type picks the method that runs
        Person person = john;
        System.out.println(person.contact("Hi"));           // Patient's version
        // person.getMobileNum();                            // would NOT compile: Person has no such method
        if (person instanceof Patient) {                     // check, then downcast
            Patient p = (Patient) person;
            System.out.println("Downcast mobile: " + p.getMobileNum() + ", id " + p.getId());
        }

        // Anonymous class: a one-off implementation written inline
        Contactable tannoy = new Contactable() {
            @Override
            public String contact(String message) {
                return "TANNOY: " + message;
            }
        };
        System.out.println(tannoy.contact("Fire drill at noon"));
        Contactable shorter = message -> "LAMBDA: " + message;   // same thing as a lambda (one-method interface)
        System.out.println(shorter.contact("Hello"));

        // Inheritance, override, overload, static
        Ward general = new Ward("Nightingale");
        Ward icu = new ICUWard("Hope");                      // declared as Ward, really an ICUWard
        System.out.println(general.getName() + " | " + icu.getName() + " | " + ((ICUWard) icu).getName(true));
        System.out.println("Wards created: " + Ward.count + ", types " + String.join(", ", Ward.getAllWardTypes()));

        // Ad hoc polymorphism
        System.out.println("add: " + add(2, 3) + " " + add(2.5, 0.5) + " " + add("2", "3"));

        // Parametric polymorphism (generics)
        CallRecord<Patient, Doctor> call = new CallRecord<>(john, hugo);
        System.out.println("Call from " + call.getCaller().getName() + " to " + call.getCallee().getName());
        ArrayList<Integer> scores = new ArrayList<>();       // Integer, not int
        scores.add(72);
        System.out.println("Generic list: " + scores);
    }
}
