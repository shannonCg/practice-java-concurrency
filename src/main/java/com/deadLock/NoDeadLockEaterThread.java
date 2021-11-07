package com.deadLock;

public class NoDeadLockEaterThread extends Thread{
    private String name;
    private final PairTool pair;

    public NoDeadLockEaterThread(String name, PairTool pair){
        this.name = name;
        this.pair = pair;
    }

    public void run(){
        while(true){
            eat();
        }
    }

    public void eat(){
        synchronized(pair){
            System.out.println(name+" takes up "+ pair+" (left and right).");
            System.out.println(name+" is eating now, yum yum!");
            System.out.println(name+" puts down "+pair+" (left and right).");
        }
    }
}
