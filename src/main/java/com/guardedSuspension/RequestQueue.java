package com.guardedSuspension;

public interface RequestQueue {
    Request getRequest();
    void putRequest(Request request);
}
