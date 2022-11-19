package org.SDA.Multithreading;

public class ThreadingExample {
    // Thread
    // Runnable

    public static void runExample() {
        deadlockExample();
    }

    public static void raceConditionExample() {
        Counter counter = new Counter();

        Thread threadA = new Thread(counter, "Thread A");
        Thread threadB = new Thread(counter, "Thread B");

        threadA.start();
        threadB.start();
    }

    public static void deadlockExample() {
        Thread threadA = new Thread(() -> {
            synchronized (IntegerData.x) {
                System.out.println(IntegerData.x);

                synchronized (IntegerData.y) {
                    System.out.println(IntegerData.y);
                }
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (IntegerData.y) {
                System.out.println(IntegerData.y);

                synchronized (IntegerData.x) {
                    System.out.println(IntegerData.x);
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
