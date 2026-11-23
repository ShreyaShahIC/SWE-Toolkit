package basics;

import java.util.Arrays;

// Tutorial 1 extra: five-band resistor colours <-> value. Shows arrays, indexOf via a loop,
// switch on Strings, static utility methods, and exceptions for bad input.
public class ResistorCalculator {
    // index = digit value, and also the multiplier power of ten (black x1 ... violet x10M)
    public static final String[] COLOURS =
            {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    public static int digitOf(String colour) {
        for (int i = 0; i < COLOURS.length; i++) {
            if (COLOURS[i].equalsIgnoreCase(colour)) return i;
        }
        throw new IllegalArgumentException("Unknown colour: " + colour);
    }

    public static double toleranceOf(String colour) {
        switch (colour.toLowerCase()) {
            case "brown":  return 1;
            case "red":    return 2;
            case "green":  return 0.5;
            case "blue":   return 0.25;
            case "violet": return 0.1;
            case "grey":   return 0.05;
            case "gold":   return 5;
            case "silver": return 10;
            default: throw new IllegalArgumentException("Not a tolerance colour: " + colour);
        }
    }

    /** bands = digit1, digit2, digit3, multiplier, tolerance. Returns ohms. */
    public static long resistance(String[] bands) {
        int value = digitOf(bands[0]) * 100 + digitOf(bands[1]) * 10 + digitOf(bands[2]);
        int power = digitOf(bands[3]);
        if (power > 7) throw new IllegalArgumentException("Multiplier band only goes up to violet");
        return value * (long) Math.pow(10, power);
    }

    /** The reverse: ohms -> the four value colours (3 digits + multiplier). */
    public static String[] coloursFor(long ohms) {
        int power = 0;
        while (ohms >= 1000) {
            if (ohms % 10 != 0) throw new IllegalArgumentException("Needs more than 3 significant digits");
            ohms /= 10;
            power++;
        }
        int d1 = (int) (ohms / 100), d2 = (int) (ohms / 10 % 10), d3 = (int) (ohms % 10);
        return new String[]{COLOURS[d1], COLOURS[d2], COLOURS[d3], COLOURS[power]};
    }

    public static void main(String[] args) {
        String[] bands = {"brown", "black", "black", "red", "brown"};
        System.out.println(Arrays.toString(bands) + " = " + resistance(bands) + " ohms +/-" + toleranceOf(bands[4]) + "%");
        String[] bands2 = {"yellow", "violet", "black", "brown", "gold"};
        System.out.println(Arrays.toString(bands2) + " = " + resistance(bands2) + " ohms +/-" + toleranceOf(bands2[4]) + "%");
        System.out.println("47000 ohms -> " + Arrays.toString(coloursFor(47000)));
        try {
            resistance(new String[]{"pink", "black", "black", "red", "brown"});
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
