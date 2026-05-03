package strategy;

import entities.Booking;

import java.time.Duration;

public class LateReturnPricingStrategy implements PricingStrategy {

    @Override
    public double calculate(Booking booking) {

        double base = booking.getCar().getPricePerDay();

        long plannedHours = Duration.between(
                booking.getStartTime(),
                booking.getEndTime()
        ).toHours();

        long actualHours = Duration.between(
                booking.getStartTime(),
                booking.getActualReturnTime()
        ).toHours();

        long extra = actualHours - plannedHours;

        if (extra > 0) {
            base += extra * 10; // ₹10/hour penalty
        }

        return base;
    }
}