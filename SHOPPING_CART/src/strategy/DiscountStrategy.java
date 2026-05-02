package strategy;

import java.util.List;

import cart.Cart;
import entities.CartItem;

public interface DiscountStrategy {
	double calculateDiscount(List<CartItem> items);
}
