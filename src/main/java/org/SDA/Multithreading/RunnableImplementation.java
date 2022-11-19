package org.SDA.Multithreading;

public class RunnableImplementation implements Runnable {
    @Override
    public void run() {
        for (Integer i = 0; i < 101; i++) {
            System.out.println("Hello, Runnable!");
        }
    }
}
