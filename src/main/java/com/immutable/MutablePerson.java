package com.immutable;

public class MutablePerson {
    private String name;
    private String address;

    public MutablePerson(String name, String address){
        this.name = name;
        this.address = address;
    }

    public MutablePerson(ImmutablePerson person){
        this.name = person.getName();
        this.address = person.getAddress();
    }

    String getName(){
        return name;
    }

    String getAddress(){
        return address;
    }

    public synchronized String toString(){
        return "[ MutablePerson: name="+name+", address="+address+" ]";
    }

    public synchronized void setPerson(String newName, String newAddress){
        name = newName;
        address = newAddress;
    }

    public synchronized ImmutablePerson getImmutablePerson(){
        return new ImmutablePerson(this);
    }
}
