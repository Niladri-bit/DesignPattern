package services;

import entities.Car;
import repository.CarRepository;

import java.util.Collection;

public class CarService {

    private final CarRepository carRepository =
            CarRepository.getInstance();

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public Car getCar(String carNo) {
        return carRepository.findById(carNo);
    }

    public Collection<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void removeCar(String carNo) {
        carRepository.delete(carNo);
    }
}