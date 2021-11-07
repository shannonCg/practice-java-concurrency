package com.synchronize;

import java.util.Date;

public class SynchronizeMethod{

    private String testName;

    public SynchronizeMethod(String testName){
        this.testName = testName;
    }

    public String getTestName(){
        return this.testName;
    }

    public synchronized void method1() {
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date()+":instance["+testName+"] finish method 1 ");
    }
    
    public synchronized void method2() {
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date()+":instance["+testName+"] finish method 2 ");
    }

    public static synchronized void method3() {
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date()+":finish static method 3 ");
    }
}
