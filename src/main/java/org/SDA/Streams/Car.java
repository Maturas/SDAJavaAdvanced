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

    public Integer getPrice() {
        return price;
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
    private final Integer price;
    private final EngineType engineType;

    public Car(String brand, String model, Integer yearProduced, Integer horsePower, Integer price, EngineType engineType) {
        this.brand = brand;
        this.model = model;
        this.yearProduced = yearProduced;
        this.horsePower = horsePower;
        this.price = price;
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %s", brand, model, yearProduced, horsePower, price, engineType.toString());
    }
}
