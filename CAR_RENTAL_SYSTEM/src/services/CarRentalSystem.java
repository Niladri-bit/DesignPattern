package services;

import java.time.Instant;

import entities.Booking;
import entities.Car;
import entities.User;
import strategy.PricingStrategy;
import strategy.WeekdayPricingStrategy;
import strategy.WeekendPricingStrategy;

public class CarRentalSystem {

    private final CarService carService;
    private final BookingService bookingService;

    // Constructor injection (good design)
    public CarRentalSystem(CarService carService,
                           BookingService bookingService) {
        this.carService = carService;
        this.bookingService = bookingService;
    }

    // -------------------------------
    // 1. Add Car (Admin use case)
    // -------------------------------
    public void addCar(Car car) {
        carService.addCar(car);
    }

    // -------------------------------
    // 2. View Car
    // -------------------------------
    public Car getCar(String carNo) {
        return carService.getCar(carNo);
    }

    // -------------------------------
    // 3. Book Car (Core flow)
    // -------------------------------
    public Booking bookCar(User user,
                           String carNo,
                           Instant start,
                           Instant end) {

        Car car = carService.getCar(carNo);

        if (car == null) {
            throw new RuntimeException("Car not found");
        }

        return bookingService.createBooking(user, car, start, end);
    }

    // -------------------------------
    // 4. Get booking details
    // -------------------------------
    public Booking getBooking(String bookingId) {
        return bookingService.getBooking(bookingId);
    }

    // -------------------------------
    // 5. Get all cars
    // -------------------------------
    public void listCars() {
        carService.getAllCars()
                .forEach(car -> System.out.println(
                        car.getCarNo() + " - " + car.getCarName()
                ));
    }
    
    
    public double returnCar(String bookingId, Instant actualReturnTime) {

        Booking booking = bookingService.getBooking(bookingId);

        if (booking == null) {
            throw new RuntimeException("Booking not found");
        }

        PricingStrategy strategy;

        // SIMPLE DECISION LOGIC (NO FACTORY NEEDED)
        var day = booking.getStartTime()
                .atZone(java.time.ZoneId.systemDefault())
                .getDayOfWeek();

        if (day == java.time.DayOfWeek.SATURDAY ||
            day == java.time.DayOfWeek.SUNDAY) {

            strategy = new WeekendPricingStrategy();
        } else {
            strategy = new WeekdayPricingStrategy();
        }

        booking.setActualReturnTime(actualReturnTime);

        return bookingService.completeBooking(
                bookingId,
                actualReturnTime,
                strategy
        );
    }
}