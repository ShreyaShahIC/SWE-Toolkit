package errors;

// Week 4: a pretend scanner we can tell to fail at any stage (a hand-made mock).
/** A pretend scanner we can tell to fail at any stage, so every path in scan() can be tried. */
public class SimulatedScanner implements Scanable {
    public enum Fault { NONE, NO_CONNECT, NO_START, NO_DATA, SCANNER_ERROR, UNEXPECTED_ERROR }

    private final Fault fault;
    private boolean connected = false;

    public SimulatedScanner(Fault fault) {
        this.fault = fault;
    }

    @Override
    public boolean connect() {
        connected = (fault != Fault.NO_CONNECT);
        return connected;
    }

    @Override
    public boolean start() throws ScanException {
        return fault != Fault.NO_START;
    }

    @Override
    public int readData(byte[] data) throws ScanException {
        switch (fault) {
            case NO_DATA:          return 0;
            case SCANNER_ERROR:    throw new ScanException("Cable chewed by cat");
            case UNEXPECTED_ERROR: throw new ArithmeticException("/ by zero");
            default:               return data.length;
        }
    }

    @Override
    public void disconnect() {
        if (connected) {
            System.out.println("  (disconnected)");
            connected = false;
        }
    }
}
