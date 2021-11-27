package com.singleThread;

public class SafeGate extends Gate{
    
    @Override
    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }
}
