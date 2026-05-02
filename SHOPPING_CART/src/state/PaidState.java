package state;

import cart.Cart;
import entities.Product;

public class PaidState implements ShoppingCartState{

	@Override
	public void addProduct(Cart cart, Product product, int quantity) {
		// TODO Auto-generated method stub
		System.out.println("Can't add product as u are in paid state");
		
	}

	@Override
	public void removeProduct(Cart cart, Product product, int quantity) {
		// TODO Auto-generated method stub
		System.out.println("Can't remove product as u are in paid state");
		
	}

	@Override
	public void checkout(Cart cart) {
		// TODO Auto-generated method stub
		System.out.println("Can't checkout product as u are in paid state");
	}

	@Override
	public void pay(Cart cart) {
		// TODO Auto-generated method stub
		System.out.println("Can't pay product as u are in paid state");
		
	}

	@Override
	public void cancel(Cart cart) {
		// TODO Auto-generated method stub
		System.out.println("Can't cancel product as u are in paid state");
		
	}

}
