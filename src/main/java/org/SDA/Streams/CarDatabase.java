package org.SDA.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class CarDatabase {
    private final Set<Car> cars;

    public CarDatabase(Set<Car> cars) {
        this.cars = cars;
    }

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

    // 4. Get all cars from given brand
    public Set<Car> getAllCarsWithGivenBrand(String brand){
//        HashSet<Car> resultBrand = new HashSet<>();
//        for(Car car : cars){
//            if(car.getBrand().equals(brand)){
//                resultBrand.add(car)
//            }
//        }
//        return resultBrand;

        // kolekcja na której bazuje nasz stream.przerabiamy na stream.funckja filtrujemy
        // .(car)-pojedynczy element (zwraca wartość true/false).może dodać kolejną funkcję
        // lub zwrócić ponownie do kolekcji tak jak w tym przypadku
        return cars.stream().filter(car -> car.getBrand().equals(brand)).collect(Collectors.toSet());
    }

    // 5. Get all cars from given year, given engine type and given brand
    public Set<Car> getAllCarsWithGivenYearEngineTypeAndBrand(Integer year, Car.EngineType engineType, String brand) {
        return cars.stream()
                .filter(car -> car.getYearProduced().equals(year))
                .filter(car -> car.getBrand().equals(brand))
                .filter(car -> car.getEngineType().equals(engineType))
                .collect(Collectors.toSet());
    }

    // 6. Get cheapest car
    public Optional<Car> getCheapestCar() {
        return cars.stream().min(Comparator.comparing(Car::getPrice));
    }

    // 7. Get most expensive car from given year
    public Optional<Car> getMostExpensiveCarFromGivenYear(Integer year) {
        return cars.stream()
                .filter(car -> car.getYearProduced().equals(year))
                .max(Comparator.comparing(Car::getPrice));
    }

    // 8. Get most powerful car with given engine type and given brand
    public Optional<Car> getMostPowerfulCarWithGivenEngineTypeAndBrand(Car.EngineType engineType, String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .filter(car -> car.getEngineType().equals(engineType))
                .max(Comparator.comparing(Car::getHorsePower));
    }

    // 9. Get average price of a car from given year
    public Double getAveragePriceOfCarFromGivenYear(Integer year) {
        return cars.stream()
                .filter(car -> car.getYearProduced().equals(year))
                .collect(Collectors.averagingInt(Car::getPrice));
    }

    public Map<Car.EngineType, Set<Car>> groupCarsPerEngineType() {
        return Arrays.stream(Car.EngineType.values())
                .collect(Collectors.toMap(engineType -> engineType,
                        engineType -> cars.stream().filter(car -> car.getEngineType()
                                .equals(engineType)).collect(Collectors.toSet())));
    }

    public static void example() {
        HashSet<Car> cars = new HashSet<>();
        cars.add(new Car("Mercedes", "W120", 1999, 100, 2000, Car.EngineType.Gasoline));
        cars.add(new Car("Mercedes", "Super", 2000, 120, 8000, Car.EngineType.Gasoline));
        cars.add(new Car("Mercedes", "AMG", 2012, 1000, 65000, Car.EngineType.Gasoline));
        cars.add(new Car("Tesla", "S", 1970, 800, 700, Car.EngineType.Diesel));
        cars.add(new Car("Tesla", "X", 2012, 70, 10000, Car.EngineType.Diesel));
        cars.add(new Car("Volkswagen", "Passat", 2012, 150, 12000, Car.EngineType.Hybrid));
        cars.add(new Car("Audi", "A8", 2090, 165, 2050, Car.EngineType.Hybrid));
        CarDatabase db = new CarDatabase(cars);

        db.getAllCars().forEach(System.out::println);
        System.out.println();
        db.getAllCarsFromYear(2012).forEach(System.out::println);
        System.out.println();
        db.getAllCarsWithGivenEngineType(Car.EngineType.Diesel).forEach(System.out::println);
        System.out.println();
        db.getAllCarsWithGivenBrand("Tesla").forEach(System.out::println);
        System.out.println();
        db.getAllCarsWithGivenYearEngineTypeAndBrand(2090, Car.EngineType.Hybrid, "Audi").forEach(System.out::println);
        System.out.println();
        db.getCheapestCar().ifPresent(System.out::println);
        System.out.println();
        db.getMostExpensiveCarFromGivenYear(2012).ifPresent(System.out::println);
        System.out.println();
        db.getMostPowerfulCarWithGivenEngineTypeAndBrand(Car.EngineType.Gasoline, "Mercedes").ifPresent(System.out::println);
        System.out.println();

        Map<Car.EngineType, Set<Car>> map = db.groupCarsPerEngineType();
        for (Car.EngineType key : map.keySet()) {
            System.out.println(key.toString());
            map.get(key).forEach(System.out::println);
        }
    }
}
