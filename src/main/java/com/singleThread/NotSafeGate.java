package com.singleThread;

public class NotSafeGate implements Gate{
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public void pass(String name, String address){
        this.counter++;
        this.name = name;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
