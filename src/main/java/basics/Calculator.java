package basics;

// Tutorial 1 Ex7: a class with a private field (running total) and public methods.
// Private: rTotal and showRT are internal details. Public: what other classes may use.
public class Calculator {
    private double rTotal;

    public Calculator(double initVal) {
        rTotal = initVal;
    }

    private void showRT() {
        System.out.println("Result=" + rTotal);
    }

    public double add(double val)      { rTotal = rTotal + val; showRT(); return rTotal; }
    public double subtract(double val) { rTotal = rTotal - val; showRT(); return rTotal; }
    public double multiply(double val) { rTotal = rTotal * val; showRT(); return rTotal; }

    public double divide(double val) {
        rTotal = rTotal / val;          // double / 0 gives Infinity, it does not throw
        showRT();
        return rTotal;
    }

    public double sqrt()               { rTotal = Math.sqrt(rTotal); showRT(); return rTotal; }
    public double power(double exp)    { rTotal = Math.pow(rTotal, exp); showRT(); return rTotal; }
    public double sin()                { rTotal = Math.sin(rTotal); showRT(); return rTotal; }
    public double log()                { rTotal = Math.log(rTotal); showRT(); return rTotal; }

    public void AC() {
        rTotal = 0;
        System.out.println("Cleared");
    }

    public double getTotal() {
        return rTotal;
    }
}
