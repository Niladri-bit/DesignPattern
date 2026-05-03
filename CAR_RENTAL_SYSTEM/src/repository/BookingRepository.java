package repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import entities.Booking;

public class BookingRepository {

    private final Map<String, Booking> bookings = new ConcurrentHashMap<>();
    private final Map<String, List<Booking>> bookingsByCar = new ConcurrentHashMap<>();

    private static final BookingRepository instance = new BookingRepository();

    private BookingRepository() {}

    public static BookingRepository getInstance() {
        return instance;
    }

    public void save(Booking booking) {
        bookings.put(booking.getBookingId(), booking);

        bookingsByCar
                .computeIfAbsent(booking.getCar().getCarNo(),
                        k -> Collections.synchronizedList(new ArrayList<>()))
                .add(booking);
    }

    public Booking findById(String id) {
        return bookings.get(id);
    }

    public List<Booking> findByCar(String carNo) {
        return bookingsByCar.getOrDefault(carNo, List.of());
    }
}