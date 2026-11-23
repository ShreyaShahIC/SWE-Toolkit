package basics;

import java.util.ArrayList;
import java.util.Arrays;

// Week 1 syntax cheat sheet you can run: primitives, casting, operators, Strings,
// if/switch, loops, break/continue, arrays, ArrayList, ternary, Math, printf, final.
public class SyntaxReference {

    public static final int NUM_PLANETS = 8;   // final = constant, UPPER_CASE by convention

    public static void main(String[] args) {
        // ---- primitives and casting ----
        int i = 34;
        double d = i;                  // implicit widening: byte->short->int->long->float->double
        int back = (int) 34.6;         // explicit narrowing truncates -> 34
        char c = 'A';
        int code = c;                  // char is a 16-bit Unicode number -> 65
        long big = 3_000_000_000L;     // L suffix for long literals
        System.out.println("casting: " + d + " " + back + " " + code + " " + big);

        // ---- arithmetic traps ----
        System.out.println("7/2=" + 7 / 2 + "  7%2=" + 7 % 2 + "  7/2.0=" + 7 / 2.0 + "  (double)7/2=" + (double) 7 / 2);
        System.out.println("1+2+\"3\"+4 = " + (1 + 2 + "3" + 4));   // 334: left to right
        int x = 5;
        int y = x++ + ++x;             // 5 + 7
        System.out.println("x++ + ++x = " + y + ", x now " + x);

        // ---- Strings: always compare with equals ----
        String name = "Ada Lovelace";
        System.out.println(name.length() + " " + name.charAt(0) + " " + name.substring(4) + " "
                + name.toUpperCase() + " " + name.contains("Love") + " " + name.indexOf("L"));
        String[] parts = name.split(" ");              // ["Ada", "Lovelace"]
        System.out.println("split: " + Arrays.toString(parts));
        System.out.println("equals: " + name.equals("Ada Lovelace") + "  equalsIgnoreCase: " + "abc".equalsIgnoreCase("ABC"));
        int parsed = Integer.parseInt("42");           // String -> int
        double parsedD = Double.parseDouble("3.5");    // String -> double
        String s = String.valueOf(99);                 // int -> String (or "" + 99)
        System.out.println("parse: " + (parsed + 1) + " " + parsedD + " " + s);
        String formatted = String.format("%s is %d years old, %.2f m tall", "Ada", 36, 1.651);
        System.out.println(formatted);

        // ---- if / else if / ternary ----
        int score = 72;
        String grade;
        if (score >= 70) grade = "First";
        else if (score >= 60) grade = "2:1";
        else grade = "Other";
        String passFail = (score >= 40) ? "pass" : "fail";
        System.out.println("grade: " + grade + ", " + passFail);

        // ---- switch: remember break, or it falls through ----
        String day = "Tue";
        switch (day) {
            case "Mon":
                System.out.println("switch: Monday");
                break;
            case "Tue":
                System.out.println("switch: Tuesday");
                break;
            default:
                System.out.println("switch: another day");
        }

        // ---- loops ----
        for (int k = 0; k < 5; k++) System.out.print(k);           // 01234
        System.out.println();
        int n = 3;
        while (n > 0) { System.out.print(n + " "); n--; }           // 3 2 1
        System.out.println();
        int m = 3;
        do { System.out.print(m + " "); m--; } while (m > 0);       // 3 2 1 (body runs first)
        System.out.println();
        for (int k = 0; k < 8; k++) {
            if (k == 2) continue;      // skip the rest of this pass
            if (k == 4) break;         // leave the loop
            System.out.print(k);       // 013
        }
        System.out.println();

        // ---- arrays: fixed size ----
        int[] primes = {2, 3, 5, 7, 11};
        int[] zeros = new int[3];                    // [0, 0, 0]
        System.out.println("array: " + primes.length + " items, first " + primes[0] + ", " + Arrays.toString(zeros));
        int sum = 0;
        for (int p : primes) sum += p;
        System.out.println("sum of primes: " + sum);

        // ---- ArrayList: growable, objects only (Integer not int) ----
        ArrayList<String> names = new ArrayList<>();
        names.add("Grace");
        names.add("Ada");
        names.add(0, "Alan");                         // insert at index 0
        names.set(1, "Grace Hopper");                 // replace index 1
        System.out.println("list: " + names + " size " + names.size() + " get(2) " + names.get(2)
                + " contains Ada " + names.contains("Ada") + " indexOf Ada " + names.indexOf("Ada"));
        names.remove("Ada");                          // by value
        names.remove(0);                              // by index
        System.out.println("after removes: " + names + " isEmpty " + names.isEmpty());
        ArrayList<Integer> nums = new ArrayList<>();
        for (int k = 1; k <= 5; k++) nums.add(k * k);
        int total = 0;
        for (int v : nums) total += v;
        System.out.println("squares " + nums + " total " + total);

        // ---- Math ----
        System.out.println("Math: " + Math.sqrt(16) + " " + Math.pow(2, 10) + " " + Math.abs(-3) + " "
                + Math.max(4, 9) + " " + Math.round(2.5) + " " + Math.PI);

        // ---- printf ----
        System.out.printf("printf: %d planets, %.3f, %s%n", NUM_PLANETS, Math.E, "done");
    }
}
