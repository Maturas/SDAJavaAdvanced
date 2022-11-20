package org.SDA.Multithreading;

public class VolatileExample {
    public static class VolatileCounter implements Runnable {
        private volatile Integer currentCount;

        public VolatileCounter() {
            this.currentCount = 1;
        }

        public void increaseTo(Integer target) {
            for (Integer i = 0; i < target; i++) {
                currentCount++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.printf("%s after increase: %d\n", Thread.currentThread().getName(), currentCount);
        }

        public void decreaseTo(Integer target) {
            for (Integer i = 0; i < target; i++) {
                currentCount--;
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

    public static void example() {
        VolatileCounter volatileCounter = new VolatileCounter();
        Thread a = new Thread(volatileCounter, "Volatile A");
        Thread b = new Thread(volatileCounter, "Volatile B");

        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        Thread c = new Thread(synchronizedCounter, "Synchronized C");
        Thread d = new Thread(synchronizedCounter, "Synchronized D");

        Counter counter = new Counter();
        Thread e = new Thread(counter, "E");
        Thread f = new Thread(counter, "F");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
    }
}
