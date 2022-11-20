package org.SDA.Multithreading;

public class Task2 {
    public static class Car {
        private final String brand;
        private final String model;

        public Car(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        @Override
        public String toString() {
            return String.format("%s %s", brand, model);
        }
    }

    public static class Bridge {
        private final Integer driveThroughTime;
        private Car currentCarOnBridge;

        public Bridge(Integer driveThroughTime) {
            this.driveThroughTime = driveThroughTime;
        }

        public synchronized void driveThrough(Car car) {
            currentCarOnBridge = car;
            System.out.printf("Car %s drives on the bridge%n", currentCarOnBridge);
            try {
                Thread.sleep(driveThroughTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Car %s drives off the bridge%n", currentCarOnBridge);
            currentCarOnBridge = null;
        }
    }

    public static void exercise() {
        Car a = new Car("Ford", "Mustang");
        Car b = new Car("Lamborghini", "Avendator");
        Bridge bridge = new Bridge(5000);

        Thread threadA = new Thread(() -> bridge.driveThrough(a));
        Thread threadB = new Thread(() -> bridge.driveThrough(b));

        threadA.start();
        threadB.start();
    }
}
