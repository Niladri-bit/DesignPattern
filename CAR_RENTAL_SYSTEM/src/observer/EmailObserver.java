package observer;

import entities.BookingEvent;
import enumerations.BookingEventType;

public class EmailObserver implements Observer{

	@Override
	public void notify(BookingEvent event) {

	    if (event.getType() == BookingEventType.CREATED) {
	        System.out.println("Email: Booking created for " +
	                event.getBooking().getUser().getEmailId());
	    }

	    if (event.getType() == BookingEventType.COMPLETED) {
	        System.out.println("Email: Booking completed, payment done");
	    }
	}

	
}
