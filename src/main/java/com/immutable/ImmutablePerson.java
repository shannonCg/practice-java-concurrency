package com.immutable;

public class ImmutablePerson {
    private final String name;
    private final String address;

    public ImmutablePerson(String name, String address){
        this.name = name;
        this.address = address;
    }

    public ImmutablePerson(MutablePerson person){
        synchronized(person){
            this.name = person.getName();
            this.address = person.getAddress();
        }
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String toString(){
        return "[ ImmutablePerson: name="+name+", address="+address+" ]";
    }
    
    public MutablePerson getMutablePerson(){
        return new MutablePerson(this);
    }
}
