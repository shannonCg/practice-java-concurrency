package com.singleThread;

public class Gate {

    protected int counter = 0;
    protected String name = "Nobody";
    protected String address = "Nowhere";

    public void pass(String name, String address){
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    protected String showInfo(){
        return "No."+counter+": "+name+", "+address;
    }

    protected void check(){
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("***** BROKEN ***** "+showInfo());
        }else{
            // System.out.println("***** SAFE ***** "+showInfo());
        }
    }
}
