package com.singleThread;

public class Main_SingleThread {
    
    public static void main(String[] args) {
        notSafeTest();
        // safeTest();
    }

    private static void notSafeTest(){
        Gate gate = new NotSafeGate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }

    private static void safeTest(){
        Gate gate = new SafeGate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
