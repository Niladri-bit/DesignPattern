package strategy;

import java.util.List;

import cart.Cart;
import entities.CartItem;

public class PercentageDiscountStrategy implements DiscountStrategy{
	
	private final double percentage;
	
	public PercentageDiscountStrategy(double percentage) {
		// TODO Auto-generated constructor stub
		this.percentage = percentage;
	}

	@Override
	public double calculateDiscount(List<CartItem> items) {
		int total = 0;
		for(CartItem cartItem:items) {
			total+= cartItem.getQuantity()*cartItem.getProduct().getPrice();
		}
		return total*(percentage/100);
	}
	
}
