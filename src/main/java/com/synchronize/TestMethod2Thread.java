package com.synchronize;

import java.util.Date;

public class TestMethod2Thread implements Runnable{
    private SynchronizeMethod method;

    public TestMethod2Thread(SynchronizeMethod method){
        this.method = method;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(new Date()+":thread ["+threadName+"] executed ["+method.getTestName()+"] method2 start");
        method.method2();
        System.out.println(new Date()+":thread ["+threadName+"] executed ["+method.getTestName()+"] method2 end");
    }
}
