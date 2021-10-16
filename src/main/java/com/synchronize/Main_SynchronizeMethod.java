package com.synchronize;

import java.util.Date;

public class Main_SynchronizeMethod {

    public static void main(String[] args) {
        /**
         * 1. two instance in two same class thread
         */
        SynchronizeMethod method1 = new SynchronizeMethod("AAA");
        SynchronizeMethod method2 = new SynchronizeMethod("BBB");
        Thread run1 = new Thread(new TestMethod1Thread(method1), "run1");
        Thread run2 = new Thread(new TestMethod1Thread(method2), "run2");
        // run1.start();
        // run2.start();

        /**
         * 2. one instance in two same class thread 
         */
        SynchronizeMethod method3 = new SynchronizeMethod("CCC");
        Thread run3 = new Thread(new TestMethod1Thread(method3), "run3");
        Thread run4 = new Thread(new TestMethod1Thread(method3), "run4");
        // run3.start();
        // run4.start();

        /**
         * 3. one instance in two different class thread 
         */
        SynchronizeMethod method4 = new SynchronizeMethod("DDD");
        Thread run5 = new Thread(new TestMethod1Thread(method4), "run5");
        Thread run6 = new Thread(new TestMethod2Thread(method4), "run6");
        // run5.start();
        // run6.start();

        /**
         * 4. two static in two same class thread
         */
        Thread run7 = new Thread(new TestMethod3Thread(), "run7");
        Thread run8 = new Thread(new TestMethod3Thread(), "run8");
        // run7.start();
        // run8.start();

        /**
         * 5. one instance and one static in three different class thread
         */
        SynchronizeMethod method5 = new SynchronizeMethod("EEE");
        Thread run9 = new Thread(new TestMethod1Thread(method5), "run9");
        Thread run10 = new Thread(new TestMethod3Thread(), "run10");
        Thread run11 = new Thread(new TestMethod4Thread(method5), "run11");
        // run9.start();
        run10.start();
        run11.start();
    }
}

class TestMethod1Thread implements Runnable{

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

class TestMethod2Thread implements Runnable{

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

class TestMethod3Thread implements Runnable{

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

class TestMethod4Thread implements Runnable{

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