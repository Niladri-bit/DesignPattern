package strategy;

import java.util.List;

import cart.Cart;
import entities.CartItem;

public class FlatDiscountStrategy implements DiscountStrategy{
	
	private final double amount;
	
	public FlatDiscountStrategy(double amount) {
		// TODO Auto-generated constructor stub
		this.amount = amount;
	}

	@Override
	public double calculateDiscount(List<CartItem> items) {
		int total = 0;
		for(CartItem cartItem:items) {
			total+= cartItem.getQuantity()*cartItem.getProduct().getPrice();
		}
		
		if(total-amount>10000 && amount<500) {
		return total-amount;
		}
		return 0;
	}
	
}
