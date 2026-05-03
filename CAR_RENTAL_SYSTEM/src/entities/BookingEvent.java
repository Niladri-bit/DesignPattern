package entities;

import entities.Booking;
import enumerations.BookingEventType;

public class BookingEvent {

    private Booking booking;
    private BookingEventType type;

    public BookingEvent(Booking booking, BookingEventType type) {
        this.booking = booking;
        this.type = type;
    }

    public Booking getBooking() {
        return booking;
    }

    public BookingEventType getType() {
        return type;
    }
}
