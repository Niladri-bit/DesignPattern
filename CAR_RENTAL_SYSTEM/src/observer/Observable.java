package observer;

import entities.BookingEvent;

public interface Observable {
	public void register(Observer obs);
	public void remove(Observer obs);
	public void notifyObservers(BookingEvent bookingEvent);
}
