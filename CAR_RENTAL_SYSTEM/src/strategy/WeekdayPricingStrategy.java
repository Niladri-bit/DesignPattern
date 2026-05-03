package strategy;

import entities.Booking;
import entities.Car;

import java.time.Duration;

public class WeekdayPricingStrategy implements PricingStrategy {

    @Override
    public double calculate(Booking booking) {

        Car car = booking.getCar();

        long hours = Duration.between(
                booking.getStartTime(),
                booking.getEndTime()
        ).toHours();

        if (hours == 0) hours = 1;

        return hours * car.getPricePerDay();
    }
}