package com.guardedSuspension;

import java.util.Date;

public class ServerThread extends Thread{
    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name){
        super(name);
        this.requestQueue = requestQueue;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            Request request = requestQueue.getRequest();
            System.out.println("["+new Date()+"]"+Thread.currentThread().getName() + " handles "+request);
        }
    }
}
