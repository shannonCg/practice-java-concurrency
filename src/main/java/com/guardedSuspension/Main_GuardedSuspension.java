package com.guardedSuspension;

public class Main_GuardedSuspension {
    public static void main(String[] args) {
        // guardedBySynchronizeTest();
        guardedByToolTest();
    }

    private static void guardedBySynchronizeTest(){
        RequestQueue requestQueue = new GuardedRequestQueue();
        new ClientThread(requestQueue, "Alice").start();
        new ServerThread(requestQueue, "Bobby").start();
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
        }
        new ServerThread(requestQueue, "Cindy").start();
    }

    private static void guardedByToolTest(){
        RequestQueue requestQueue = new GuardedRequestQueueWithTool();
        new ClientThread(requestQueue, "Alice").start();
        new ServerThread(requestQueue, "Bobby").start();
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
        }
        new ServerThread(requestQueue, "Cindy").start();
    }
}
