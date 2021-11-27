package com.guardedSuspension;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GuardedRequestQueueWithTool implements RequestQueue{
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    @Override
    public Request getRequest() {
        Request request = null;
        try {
            request = queue.take();
        } catch (InterruptedException e) {
        }
        return request;
    }

    @Override
    public void putRequest(Request request) {
        try {
            queue.put(request);
        } catch (InterruptedException e) {
        }
    }
    
}
