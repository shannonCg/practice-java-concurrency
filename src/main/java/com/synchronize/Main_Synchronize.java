package com.synchronize;

public class Main_Synchronize {

    public static void main(String[] args) {
        /**
         * 1. two instance in two same class thread
         */
        // test1();

        /**
         * 2. one instance in two same class thread 
         */
        // test2();

        /**
         * 3. one instance in two different class thread 
         */
        // test3();

        /**
         * 4. two static in two same class thread
         */
        // test4();

        /**
         * 5. one instance and one static in three different class thread
         */
        test5();
    }

    private static void test1() {
        /**
         * 1. two instance in two same class thread
         */
        SynchronizeMethod method1 = new SynchronizeMethod("AAA");
        SynchronizeMethod method2 = new SynchronizeMethod("BBB");
        Thread run1 = new Thread(new TestMethod1Thread(method1), "run1");
        Thread run2 = new Thread(new TestMethod1Thread(method2), "run2");
        run1.start();
        run2.start();
    }

    private static void test2() {
        /**
         * 2. one instance in two same class thread 
         */
        SynchronizeMethod method3 = new SynchronizeMethod("CCC");
        Thread run3 = new Thread(new TestMethod1Thread(method3), "run3");
        Thread run4 = new Thread(new TestMethod1Thread(method3), "run4");
        run3.start();
        run4.start();
    }

    private static void test3(){
        /**
         * 3. one instance in two different class thread 
         */
        SynchronizeMethod method4 = new SynchronizeMethod("DDD");
        Thread run5 = new Thread(new TestMethod1Thread(method4), "run5");
        Thread run6 = new Thread(new TestMethod2Thread(method4), "run6");
        run5.start();
        run6.start();
    }

    private static void test4(){
        /**
         * 4. two static in two same class thread
         */
        Thread run7 = new Thread(new TestMethod3Thread(), "run7");
        Thread run8 = new Thread(new TestMethod3Thread(), "run8");
        run7.start();
        run8.start();
    }

    private static void test5(){
        /**
         * 5. one instance and one static in three different class thread
         */
        SynchronizeMethod method5 = new SynchronizeMethod("EEE");
        Thread run9 = new Thread(new TestMethod1Thread(method5), "run9");
        Thread run10 = new Thread(new TestMethod3Thread(), "run10");
        Thread run11 = new Thread(new TestMethod4Thread(method5), "run11");
        run9.start();
        run10.start();
        run11.start();
    }
}
