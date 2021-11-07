package com.synchronize;

import java.util.Date;

public class TestMethod4Thread implements Runnable{
    private SynchronizeMethod method;

    public TestMethod4Thread(SynchronizeMethod method){
        this.method = method;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(new Date()+":thread ["+threadName+"] executed static method3 by ["+method.getTestName()+"] start");
        method.method3();
        System.out.println(new Date()+":thread ["+threadName+"] executed static method3 by ["+method.getTestName()+"] end");
    }
}
