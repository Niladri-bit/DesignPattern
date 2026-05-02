package state;

import cart.Cart;
import entities.Product;
import enumerations.CartState;

public class CheckedOutState implements ShoppingCartState{

	@Override
	public void addProduct(Cart cart, Product product, int quantity) {
		System.out.println("No more product can be added as it is being checkedout");
		
	}

	@Override
	public void removeProduct(Cart cart, Product product, int quantity) {
		// TODO Auto-generated method stub
		System.out.println("No more product can be removed as it is being checkedout");
		
	}

	@Override
	public void checkout(Cart cart) {
		// TODO Auto-generated method stub
		System.out.println("No more product can be checkedout as it is being checkedout");
		
	}

	@Override
	public void pay(Cart cart) {
		// TODO Auto-generated method stub
		cart.setCartStateEnum(CartState.PAID);
		cart.generateBill();
		cart.setCartState(new PaidState());
		
		
	}

	@Override
	public void cancel(Cart cart) {
		// TODO Auto-generated method stub
		cart.setCartStateEnum(CartState.CANCELED);
		cart.setCartState(new CanceledState());
		System.out.println("Cart canceled");
		
	}

}
