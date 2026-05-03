package strategy;

import entities.Booking;

public interface PricingStrategy {
    double calculate(Booking booking);
}