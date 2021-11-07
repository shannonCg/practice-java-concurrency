package com.concurrentTool;

/*
*使用concurrent的工具類來在限有資源下執行多工處理
*/
public class Main_Semaphore {
    public static void main(String[] args) {
        BoundedResource boundedResource = new BoundedResource(3);
    
        for(int i = 0; i < 10; i++){
            new UserThread(boundedResource).start();
        }
    }
}
