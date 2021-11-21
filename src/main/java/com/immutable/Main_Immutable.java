package com.immutable;

public class Main_Immutable {
    public static void main(String[] args) {
        /* 物件的字段被指定後就不會被改變，因此在多執行緒下物件是安全的*/
        ImmutablePerson person = new ImmutablePerson("Alice", "Alaska");
        new PrintPersonThread(person).start();
        new PrintPersonThread(person).start();
        new PrintPersonThread(person).start();
    }
}
