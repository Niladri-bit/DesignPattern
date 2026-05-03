package client;

import java.time.Instant;

import entities.Booking;
import entities.Car;
import entities.User;
import enumerations.CarType;
import observer.EmailObserver;
import observer.MessageObserver;
import observer.Observer;
import services.CarRentalSystem;

public class Client {

    public static void main(String[] args) {

        // ----------------------------
        // 1. Get system instance
        // ----------------------------
        CarRentalSystem system = CarRentalSystem.getInstance();
        

        Observer emailObserver = new EmailObserver();
        Observer smsObserver = new MessageObserver();

        system.registerObserver(emailObserver);
        system.registerObserver(smsObserver);

        // ----------------------------
        // 2. Create user
        // ----------------------------
        User user1 = new User(
                "A123",
                "John",
                "9876543210",
                "john@gmail.com",
                "DL12345"
        );

        // ----------------------------
        // 3. Add cars
        // ----------------------------
        system.addCar(new Car("KA01AB1234", "Honda City", CarType.SEDAN, 2000));
        system.addCar(new Car("KA02CD5678", "Toyota Fortuner", CarType.SUV, 5000));

        // ----------------------------
        // 4. List cars
        // ----------------------------
        System.out.println("Available Cars:");
        system.listCars();

        // ----------------------------
        // 5. Book car
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

        // ----------------------------
        // 6. Try double booking (should fail)
        // ----------------------------
        try {
            system.bookCar(user1, "KA01AB1234", start, end);
        } catch (Exception e) {
            System.out.println("\nSecond booking failed: " + e.getMessage());
        }

        // ----------------------------
        // 7. RETURN FLOW (IMPORTANT)
        // ----------------------------
        System.out.println("\nReturning car...");

        Instant actualReturnTime = end.plusSeconds(2 * 3600); // returned late by 2 hours

        double finalAmount = system.returnCar(
                booking.getBookingId(),
                actualReturnTime
        );

        System.out.println("\nFinal Bill Generated:");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Total Amount: " + finalAmount);

        // ----------------------------
        // 8. Fetch booking after return
        // ----------------------------
        Booking updated = system.getBooking(booking.getBookingId());

        System.out.println("\nBooking Status After Return:");
        System.out.println("Booking ID: " + updated.getBookingId());
        System.out.println("Actual Return Time: " + updated.getActualReturnTime());
    }
}