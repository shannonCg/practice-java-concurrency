package com.guardedSuspension.talk;

import com.guardedSuspension.GuardedRequestQueueWithTool;
import com.guardedSuspension.Request;
import com.guardedSuspension.RequestQueue;

public class Main_Talk {
    public static void main(String[] args) {
        RequestQueue requestQueue1 = new GuardedRequestQueueWithTool();
        RequestQueue requestQueue2 = new GuardedRequestQueueWithTool();
        new TalkThread(requestQueue1, requestQueue2, "Alice").start();
        new TalkThread(requestQueue2, requestQueue1, "Bobby").start();
        
        Request firstRequest = new Request("Hello");
        requestQueue1.putRequest(firstRequest);
    }
}
