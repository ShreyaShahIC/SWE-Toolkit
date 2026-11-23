package oop;

// Week 3: subtype polymorphism. One ArrayList<Contactable> holds patients, doctors and scanners.
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private final ArrayList<Contactable> contacts = new ArrayList<>();
    private int failedLastBroadcast = 0;

    public void addContact(Contactable c) {
        contacts.add(c);
    }

    public int getContactCount() {
        return contacts.size();
    }

    /** Sends the message to everyone. Returns what was sent; skips anyone who can't be reached. */
    public List<String> broadcast(String message) {
        List<String> sent = new ArrayList<>();
        failedLastBroadcast = 0;
        for (Contactable c : contacts) {          // subtype polymorphism
            try {
                sent.add(c.contact(message));       // runs Patient/Doctor/Scanner version
            } catch (IllegalStateException e) {
                failedLastBroadcast++;
                System.out.println("Could not contact: " + e.getMessage());
            }
        }
        return sent;
    }

    public int getFailedLastBroadcast() {
        return failedLastBroadcast;
    }
}
