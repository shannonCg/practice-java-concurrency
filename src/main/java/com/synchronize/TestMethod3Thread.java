package com.synchronize;

import java.util.Date;

public class TestMethod3Thread implements Runnable{
    
    public TestMethod3Thread(){
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(new Date()+":thread ["+threadName+"] executed static method3 by class start");
        SynchronizeMethod.method3();
        System.out.println(new Date()+":thread ["+threadName+"] executed static method3 by class end");
    }
}
