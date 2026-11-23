package oop;

// Week 3: parametric polymorphism (generics). K and V are filled in when the class is used,
// e.g. CallRecord<Patient, Doctor>. Generics only work with objects, never primitives.
public class CallRecord<K, V> {
    private final K caller;
    private final V callee;
    private final long time;

    public CallRecord(K caller, V callee) {
        this.caller = caller;
        this.callee = callee;
        this.time = System.currentTimeMillis();
    }

    public K getCaller() { return caller; }
    public V getCallee() { return callee; }
    public long getTime() { return time; }
}
