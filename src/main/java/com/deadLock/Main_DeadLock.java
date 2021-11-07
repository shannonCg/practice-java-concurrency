package com.deadLock;

public class Main_DeadLock {
    public static void main(String[] args) {
        // deadLock();
        // fixDeadLock1();
        fixDeadLock2();
    }
    
    private static void deadLock(){
        /**
         * 造成死鎖的條件：
         * 1. 存在多個SharedResource角色(ex: spoon&fork)
         * 2. 線程在持有某個SharedResource角色的鎖的同時，還想獲取其他SharedResource角色的鎖
         * (ex: 兩層synchronized(){})
         * 3. 獲取SharedResource角色的鎖的順序不固定(ex: spoon和fork型態相同)
         */

        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        new DeadLockEaterThread("Alick", spoon, fork).start();
        new DeadLockEaterThread("Bobby", fork, spoon).start();
    }

    private static void fixDeadLock1(){
        /* 使用順序一致：違反死鎖條件的第三點 */
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        new DeadLockEaterThread("Alick", spoon, fork).start();
        new DeadLockEaterThread("Bobby", spoon, fork).start();
    }

    private static void fixDeadLock2(){
        /* 把兩個工具包裝在另一個物件來使用：違反死鎖條件的第一點和第二點 */
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        PairTool pair = new PairTool(spoon, fork);
        new NoDeadLockEaterThread("Alick", pair).start();
        new NoDeadLockEaterThread("Bobby", pair).start();
    }
}
