package com.singleThread.mutex;

public class SimpleMutex implements Mutex{
 
    private boolean isLock = false;

    public synchronized void lock(){
        while (isLock) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        isLock = true;
    }

    public synchronized void unlock(){
        isLock = false;
        notifyAll();
    }
}
