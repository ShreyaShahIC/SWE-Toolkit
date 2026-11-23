package basics;

import java.util.ArrayList;
import java.util.Scanner;

// Tutorial 1 extra: read numbers from the keyboard, print min, max, mean, standard deviation.
// Needs  run { standardInput = System.in }  in build.gradle if run through Gradle.
public class StatsFromKeyboard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> values = new ArrayList<>();
        System.out.println("Type numbers separated by spaces or new lines, then 'done':");
        while (scan.hasNextDouble()) {
            values.add(scan.nextDouble());
        }
        if (values.isEmpty()) {
            System.out.println("No numbers entered.");
            return;
        }
        double min = values.get(0), max = values.get(0), sum = 0;
        for (double v : values) {
            if (v < min) min = v;
            if (v > max) max = v;
            sum += v;
        }
        double mean = sum / values.size();
        double squares = 0;
        for (double v : values) squares += (v - mean) * (v - mean);
        double sd = values.size() > 1 ? Math.sqrt(squares / (values.size() - 1)) : 0;  // sample SD
        System.out.printf("n=%d min=%.2f max=%.2f mean=%.2f sd=%.2f%n", values.size(), min, max, mean, sd);
    }
}
