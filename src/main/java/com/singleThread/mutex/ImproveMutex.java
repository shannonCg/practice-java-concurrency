package com.singleThread.mutex;

public class ImproveMutex implements Mutex{

    private long locks = 0;
    private Thread owner = null;

    @Override
    public synchronized void lock() {
        Thread me = Thread.currentThread();
        while (locks > 0 && owner != me) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if(locks == 0 || owner == me){
            locks++;
            owner = me;
        }
    }

    @Override
    public synchronized void unlock() {
        Thread me = Thread.currentThread();
        if(locks == 0 || owner != me){
            return;
        }

        if(locks > 0 && owner == me){
            locks--;
            if(locks == 0){
                owner = null;
            }
        }
    }
    
}
