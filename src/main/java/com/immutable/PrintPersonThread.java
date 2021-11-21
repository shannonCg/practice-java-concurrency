package com.immutable;

public class PrintPersonThread extends Thread{
    private ImmutablePerson person;
    public PrintPersonThread(ImmutablePerson person){
        this.person = person;
    }

    public void run(){
        while (true) {
            System.out.println(Thread.currentThread().getName()+" prints "+person);
        }
    }
}
