package observer;

import entities.Booking;
import entities.BookingEvent;

public interface Observer {

	public void notify(BookingEvent bookingEvent);
}
