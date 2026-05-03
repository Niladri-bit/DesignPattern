package repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import entities.Car;

public class CarRepository {

    private final Map<String, Car> cars = new ConcurrentHashMap<>();

    private static final CarRepository instance = new CarRepository();

    private CarRepository() {}

    public static CarRepository getInstance() {
        return instance;
    }

    public void save(Car car) {
        cars.put(car.getCarNo(), car);
    }

    public Car findById(String carNo) {
        return cars.get(carNo);
    }

    public void delete(String carNo) {
        cars.remove(carNo);
    }

    public Collection<Car> findAll() {
        return cars.values();
    }
}