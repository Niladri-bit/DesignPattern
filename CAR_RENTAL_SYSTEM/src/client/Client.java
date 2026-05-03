package client;

import java.time.Instant;

import entities.Booking;
import entities.Car;
import entities.User;
import enumerations.CarType;
import services.BookingService;
import services.CarRentalSystem;
import services.CarService;

public class Client {

    public static void main(String[] args) {

        // ----------------------------
        // 1. Setup system (dependency injection)
        // ----------------------------
        CarService carService = new CarService();
        BookingService bookingService = new BookingService();

        CarRentalSystem system =
                new CarRentalSystem(carService, bookingService);

        // ----------------------------
        // 2. Create users
        // ----------------------------
        User user1 = new User(
                "A123",
                "John",
                "9876543210",
                "john@gmail.com",
                "DL12345"
        );

        // ----------------------------
        // 3. Add cars (Admin action)
        // ----------------------------
        Car car1 = new Car("KA01AB1234", "Honda City", CarType.SEDAN, 2000);
        Car car2 = new Car("KA02CD5678", "Toyota Fortuner", CarType.SUV, 5000);

        system.addCar(car1);
        system.addCar(car2);

        // ----------------------------
        // 4. List cars
        // ----------------------------
        System.out.println("Available Cars:");
        system.listCars();

        // ----------------------------
        // 5. Book a car
        // ----------------------------
        Instant start = Instant.now();
        Instant end = start.plusSeconds(3600 * 24); // 1 day

        Booking booking = system.bookCar(
                user1,
                "KA01AB1234",
                start,
                end
        );

        System.out.println("\nBooking Created:");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Car: " + booking.getCar().getCarName());
        System.out.println("User: " + booking.getUser().getName());

        // ----------------------------
        // 6. Fetch booking
        // ----------------------------
        Booking fetched = system.getBooking(booking.getBookingId());

        System.out.println("\nFetched Booking:");
        System.out.println(fetched.getBookingId() + " -> " +
                fetched.getCar().getCarNo());

        // ----------------------------
        // 7. Try booking same car again (should fail if overlap)
        // ----------------------------
        try {
            system.bookCar(user1, "KA01AB1234", start, end);
        } catch (Exception e) {
            System.out.println("\nSecond booking failed: " + e.getMessage());
        }
    }
}