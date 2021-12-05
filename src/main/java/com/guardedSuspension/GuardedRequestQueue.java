package com.guardedSuspension;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class GuardedRequestQueue implements RequestQueue{

    private final Queue<Request> queue = new LinkedList<>();

    @Override
    public synchronized Request getRequest() {
        System.out.println("["+new Date()+"]"+Thread.currentThread().getName()+" start get request...");
        while(Objects.isNull(queue.peek())){
            try {
                System.out.println("["+new Date()+"]"+Thread.currentThread().getName()+" before wait, queue="+queue);
                wait();
                System.out.println("["+new Date()+"]"+Thread.currentThread().getName()+" after wait, queue="+queue);
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
