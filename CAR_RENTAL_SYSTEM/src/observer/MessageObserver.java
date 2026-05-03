package observer;

import entities.BookingEvent;
import enumerations.BookingEventType;

public class MessageObserver implements Observer{

	@Override
	public void notify(BookingEvent event) {

	    if (event.getType() == BookingEventType.CREATED) {
	        System.out.println("Message: Booking created for " +
	                event.getBooking().getUser().getMobileNo());
	    }

	    if (event.getType() == BookingEventType.COMPLETED) {
	        System.out.println("Message: Booking completed, payment done");
	    }
	}

	
}
