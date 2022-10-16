package org.SDA.Streams;

public class Car {
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getYearProduced() {
        return yearProduced;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public enum EngineType {
        Gasoline,
        Diesel,
        Hybrid,
        Electric
    }

    private final String brand;
    private final String model;
    private final Integer yearProduced;
    private final Integer horsePower;
    private final EngineType engineType;

    public Car(String brand, String model, Integer yearProduced, Integer horsePower, EngineType engineType) {
        this.brand = brand;
        this.model = model;
        this.yearProduced = yearProduced;
        this.horsePower = horsePower;
        this.engineType = engineType;
    }
}
