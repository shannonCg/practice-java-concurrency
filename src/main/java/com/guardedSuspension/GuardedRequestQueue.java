package com.guardedSuspension;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class GuardedRequestQueue implements RequestQueue{

    private final Queue<Request> queue = new LinkedList<>();

    @Override
    public synchronized Request getRequest() {
        System.out.println("["+new Date()+"]"+"start get request...");
        while(Objects.isNull(queue.peek())){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        return queue.remove();
    }

    @Override
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
    
}
