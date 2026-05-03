package entities;

import java.time.Instant;

public class Booking {
	private String bookingId;
	private Car car;
	private User user;
	private Instant startTime;
	private Instant endTime;
	private Instant actualReturnTime;
	public Booking(String bookingId, Car car, User user, Instant startTime, Instant endTime) {
		super();
		this.bookingId = bookingId;
		this.car = car;
		this.user = user;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Instant getStartTime() {
		return startTime;
	}
	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}
	public Instant getEndTime() {
		return endTime;
	}
	public void setEndTime(Instant endTime) {
		this.endTime = endTime;
	}
	public Instant getActualReturnTime() {
		return actualReturnTime;
	}
	public void setActualReturnTime(Instant actualReturnTime) {
		this.actualReturnTime = actualReturnTime;
	}
	
	
	
}
