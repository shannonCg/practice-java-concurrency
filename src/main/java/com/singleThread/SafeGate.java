package com.singleThread;

public class SafeGate implements Gate{
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    @Override
    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }
    
    private String showInfo(){
        return "No."+counter+": "+name+", "+address;
    }

    private void check(){
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("***** BROKEN ***** "+showInfo());
        }
    }
}
