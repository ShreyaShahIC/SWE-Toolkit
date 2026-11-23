package errors;

// Week 4 driver: runs scan() once per simulated fault and prints the ScanErr each time.
public class ErrorsDemo {
    public static void main(String[] args) {
        for (SimulatedScanner.Fault fault : SimulatedScanner.Fault.values()) {
            System.out.println("Simulating " + fault + ":");
            UltrasoundInvestigation investigation = new UltrasoundInvestigation(new SimulatedScanner(fault));
            ScanErr result = investigation.scan();
            System.out.println("  result = " + result);
        }
    }
}
