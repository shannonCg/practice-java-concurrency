package com.singleThread;

public class Main_SingleThread {
    
    public static void main(String[] args) {
        // notSafeTest();
        // safeTest();
        mutexTest();
    }

    private static void notSafeTest(){
        Gate gate = new Gate();
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

    private static void mutexTest(){
        Gate gate = new MutexGate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
