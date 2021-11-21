package com.immutable;

public class Main_ComputeSpeedCompare {
    private static final long CALL_COUNT = 1000000000L;
    public static void main(String[] args) {
        trial("Sync", CALL_COUNT, new Sync());
        trial("NotSync", CALL_COUNT, new NotSync());
    }

    private static void trial(String msg, long count, Object obj){
        System.out.println(msg+": BEGIN");
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < count; i++){
            obj.toString();
        }
        System.out.println(msg+": END");
        System.out.println("Elapsed time = "+(System.currentTimeMillis() - startTime)/1000+" sec.");
    }
}

class Sync{
    private final String name = "Sync";

    public synchronized String toString(){
        return "[" + name + "]";
    }
}

class NotSync{
    private final String name = "NotSync";

    public synchronized String toString(){
        return "[" + name + "]";
    }
}