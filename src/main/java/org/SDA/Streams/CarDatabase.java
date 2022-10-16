package org.SDA.Streams;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CarDatabase {
    private final Set<Car> cars;

    public CarDatabase(Set<Car> cars) {
        this.cars = cars;
    }

    // 4. Get all cars from given brand
    // 5. Get all cars from given, given engine type and given brand

    // 6. Get cheapest car
    // 7. Get most expensive car from given year
    // 8. Get cheapest car with given engine type and given brand

    // 9. Get average price of a car from given year
    // 10. Get maximum horsepower for each engine type of all cars from given year

    // 1. Get all cars
    public Set<Car> getAllCars() {
        return new HashSet<>(cars);
    }

    // 2. Get all cars from given year
    public Set<Car> getAllCarsFromYear(Integer year) {
        /*
        HashSet<Car> resultCars = new HashSet<>();
        for (Car car : cars) {
            if (car.getYearProduced().equals(year)) {
                resultCars.add(car);
            }
        }
        return resultCars;
        */
        return cars.stream().filter(car -> car.getYearProduced()
                .equals(year)).collect(Collectors.toSet());
    }

    // 3. Get all cars of given engine type
    public Set<Car> getAllCarsWithGivenEngineType(Car.EngineType engineType) {
        /*
        HashSet<Car> resultCars = new HashSet<>();
        for (Car car : cars) {
            if (car.getEngineType().equals(engineType)) {
                resultCars.add(car);
            }
        }
        return resultCars;
        */
        return cars.stream().filter(car -> car.getEngineType()
                .equals(engineType)).collect(Collectors.toSet());
    }
}
