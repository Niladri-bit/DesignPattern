package strategy;

import entities.Booking;
import entities.Car;

import java.time.DayOfWeek;
import java.time.ZoneId;
import java.time.Duration;

public class WeekendPricingStrategy implements PricingStrategy {

    @Override
    public double calculate(Booking booking) {

        Car car = booking.getCar();

        long hours = Duration.between(
                booking.getStartTime(),
                booking.getEndTime()
        ).toHours();

        if (hours == 0) hours = 1;

        double base = hours * car.getPricePerDay();

        DayOfWeek day = booking.getStartTime()
                .atZone(ZoneId.systemDefault())
                .getDayOfWeek();

        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            base += base * 0.10;
        }

        return base;
    }
}