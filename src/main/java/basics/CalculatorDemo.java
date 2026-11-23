package basics;

// Tutorial 1 Ex7 driver, including the two loop exercises.
public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator(0);
        calc.add(5.2);
        calc.add(1.75);
        calc.multiply(2);
        calc.subtract(0.9);
        calc.divide(2);
        calc.sqrt();
        calc.power(2);
        calc.AC();

        // add 0..10 inclusive
        for (int i = 0; i <= 10; i++) calc.add(i);
        calc.AC();
        // 10, 8, 6, 4, 2
        for (int i = 10; i > 0; i = i - 2) calc.add(i);

        // product of all odd numbers from 7 to 15 inclusive
        Calculator product = new Calculator(1);
        for (int i = 7; i <= 15; i += 2) product.multiply(i);
        System.out.println("Product of odds 7..15 = " + product.getTotal());

        // sum of even numbers 2..100 inclusive that are not multiples of 6
        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            if (i % 6 == 0) continue;
            sum += i;
        }
        System.out.println("Sum of evens 2..100, not multiples of 6 = " + sum);
    }
}
