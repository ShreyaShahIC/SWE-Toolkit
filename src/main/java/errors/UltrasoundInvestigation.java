package errors;

import java.util.logging.Logger;

// Week 4 example from class: handle every path through the code.
// Expected failures -> enum return codes. Exceptions -> catch, most specific first.
// finally -> always disconnect. Logger -> record what happened.
public class UltrasoundInvestigation {
    private static final Logger log = Logger.getLogger(UltrasoundInvestigation.class.getName());
    public static final int SCAN_DATA_SIZE = 1024;

    private final Scanable scanner;           // depend on the interface, not a concrete class
    private final byte[] data = new byte[SCAN_DATA_SIZE];

    public UltrasoundInvestigation(Scanable scanner) {
        this.scanner = scanner;
        log.info("Investigation created");
    }

    public ScanErr scan() {
        if (!scanner.connect()) {
            log.warning("Scanner did not connect");
            return ScanErr.SCAN_ERR_NO_CONNECT;   // nothing to disconnect yet
        }
        ScanErr result = ScanErr.SCAN_SUCCESS;
        try {
            if (!scanner.start()) {
                result = ScanErr.SCAN_ERR_NO_START;
            } else if (scanner.readData(data) == 0) {
                result = ScanErr.SCAN_ERR_NO_DATAREAD;
            }
        } catch (ScanException e) {               // most specific first
            log.severe("Scanner error: " + e.getMessage());
            result = ScanErr.SCAN_ERR_FATAL_SCANNER_ERROR;
        } catch (Exception e) {                   // anything else
            log.severe("Unexpected error: " + e.getMessage());
            result = ScanErr.SCAN_ERR_FATAL_ERROR;
        } finally {
            scanner.disconnect();                 // ALWAYS runs: success, error or exception
        }
        return result;
    }

    public byte[] getImage() {
        return data;
    }
}
