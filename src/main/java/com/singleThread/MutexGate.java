package com.singleThread;

import com.singleThread.mutex.Mutex;
import com.singleThread.mutex.SimpleMutex;

public class MutexGate extends Gate{

    private final Mutex mutex = new SimpleMutex();
    // private final Mutex mutex = new ImproveMutex();
    // private final Mutex mutex = new MutexByTool();

    @Override
    public void pass(String name, String address) {
        mutex.lock();
        // mutex.lock(); //如果是simpleMutex就會自己被自己鎖住
        try{
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        }finally{
            mutex.unlock();
        }
    }
}
