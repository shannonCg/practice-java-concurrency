package com.synchronize;

import java.util.Date;

public class TestMethod1Thread implements Runnable{
    private SynchronizeMethod method;

    public TestMethod1Thread(SynchronizeMethod method){
        this.method = method;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(new Date()+":thread ["+threadName+"] executed ["+method.getTestName()+"] method1 start");
        method.method1();
        System.out.println(new Date()+":thread ["+threadName+"] executed ["+method.getTestName()+"] method1 end");
    }
}
