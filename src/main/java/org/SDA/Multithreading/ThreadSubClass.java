package org.SDA.Multithreading;

public class ThreadSubClass extends Thread {
    @Override
    public void run() {
        for (Integer i = 0; i < 500; i++) {
            System.out.println("Hello, Thread!");
        }
    }
}
