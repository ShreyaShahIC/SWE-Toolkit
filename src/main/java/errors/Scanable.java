package errors;

// Week 4: interface as a contract, including which methods may throw.
public interface Scanable {
    boolean connect();                                  // true if connected
    boolean start() throws ScanException;               // true if started OK
    int readData(byte[] data) throws ScanException;     // number of bytes read
    void disconnect();
}
