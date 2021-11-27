package com.guardedSuspension;

import java.util.Date;

public class ClientThread extends Thread{
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name){
        super(name);
        this.requestQueue = requestQueue;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            Request request = new Request("No."+i);
            System.out.println("["+new Date()+"]"+Thread.currentThread().getName() + " request "+request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(4*1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
