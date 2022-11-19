package org.SDA.Multithreading;

public class Counter implements Runnable {
    private Integer currentCount;

    public Counter() {
        this.currentCount = 1;
    }

    public void increase() {
        currentCount++;
    }

    public void decrease() {
        currentCount--;
    }

    public synchronized void increaseTo(Integer target) {
        for (Integer i = 0; i < target; i++) {
            increase();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("%s after increase: %d\n", Thread.currentThread().getName(), currentCount);
    }

    public synchronized void decreaseTo(Integer target) {
        for (Integer i = 0; i < target; i++) {
            decrease();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("%s after decrease: %d\n", Thread.currentThread().getName(), currentCount);
    }

    @Override
    public void run() {
        increaseTo(100);
        decreaseTo(100);
    }
}
