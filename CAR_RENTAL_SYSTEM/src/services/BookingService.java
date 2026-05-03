package services;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import entities.Booking;
import entities.BookingEvent;
import entities.Car;
import entities.User;
import enumerations.BookingEventType;
import observer.Observable;
import observer.Observer;
import repository.BookingRepository;
import strategy.PricingStrategy;

public class BookingService implements Observable{

    private final BookingRepository bookingRepository =
            BookingRepository.getInstance();

    private List<Observer> observers = new CopyOnWriteArrayList<>();
    // -----------------------------
    // CREATE BOOKING
    // -----------------------------
    public Booking createBooking(User user, Car car, Instant start, Instant end) {

        synchronized (car.getCarNo().intern()) {

            if (!isAvailable(car, start, end)) {
                throw new RuntimeException("Car not available");
            }

            Booking booking = new Booking(
                    UUID.randomUUID().toString(),
                    car,
                    user,
                    start,
                    end
            );

            bookingRepository.save(booking);
            notifyObservers(new BookingEvent(booking, BookingEventType.CREATED));
            return booking;
        }
    }

    // -----------------------------
    // AVAILABILITY CHECK
    // -----------------------------
    public boolean isAvailable(Car car, Instant start, Instant end) {

        var bookings = bookingRepository.findByCar(car.getCarNo());

        for (Booking b : bookings) {
            if (!(b.getEndTime().isBefore(start) ||
                  b.getStartTime().isAfter(end))) {
                return false;
            }
        }
        return true;
    }

    // -----------------------------
    // GET BOOKING
    // -----------------------------
    public Booking getBooking(String bookingId) {
        return bookingRepository.findById(bookingId);
    }

    // -----------------------------
    // COMPLETE BOOKING (FIXED)
    // -----------------------------
    public double completeBooking(String bookingId,
                                  Instant actualReturnTime,
                                  PricingStrategy pricingStrategy) {

        Booking booking = bookingRepository.findById(bookingId);

        if (booking == null) {
            throw new RuntimeException("Invalid booking");
        }

        booking.setActualReturnTime(actualReturnTime);
        notifyObservers(new BookingEvent(booking, BookingEventType.COMPLETED));
        return pricingStrategy.calculate(booking);
    }

	@Override
	public void register(Observer obs) {
		observers.add(obs);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Observer obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
		
	}

	@Override
	public void notifyObservers(BookingEvent booking) {
		// TODO Auto-generated method stub
		for(Observer obs:observers) {
			obs.notify(booking);
		}
		
	}
}