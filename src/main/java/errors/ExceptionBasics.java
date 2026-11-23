package errors;

// Week 4 basics you can run: the three unchecked exceptions from the slides, a checked
// exception that must be declared, an exception travelling up the call stack, and finally.
public class ExceptionBasics {

    // A checked exception must be declared with "throws" (or caught here).
    static int parsePositive(String text) throws ScanException {
        int value = Integer.parseInt(text);          // may throw NumberFormatException (unchecked)
        if (value <= 0) {
            throw new ScanException("Expected a positive number, got " + value);
        }
        return value;
    }

    // Not caught here, so it passes up to whoever called this method.
    static int divide(int a, int b) {
        return a / b;                                // b == 0 -> ArithmeticException
    }

    static String withFinally() {
        try {
            return "returned from try";
        } finally {
            System.out.println("finally runs before the method actually returns");
        }
    }

    public static void main(String[] args) {
        // 1. ArithmeticException: int division by zero (double division gives Infinity instead)
        try {
            System.out.println(divide(4, 0));
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }
        System.out.println("4.0 / 0 = " + (4.0 / 0));

        // 2. NullPointerException: using an object reference that points to nothing
        String missing = null;
        try {
            System.out.println(missing.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
        }

        // 3. ArrayIndexOutOfBoundsException: valid indexes are 0..length-1
        int[] vals = new int[5];
        try {
            vals[7] = 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // 4. Checked exception, multiple catch blocks (specific first), finally
        String[] inputs = {"12", "-3", "abc"};
        for (String in : inputs) {
            try {
                System.out.println("parsed " + parsePositive(in));
            } catch (ScanException e) {
                System.out.println("ScanException: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException: " + e.getMessage());
            } finally {
                System.out.println("  (finished input " + in + ")");
            }
        }

        // 5. finally runs even when try returns
        System.out.println(withFinally());

        // 6. Throwing your own unchecked exception for bad arguments
        try {
            new dosage.Patient("Bad", 0, 30);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
    }
}
