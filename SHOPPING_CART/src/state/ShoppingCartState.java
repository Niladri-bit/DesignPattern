package state;

import cart.Cart;
import entities.Product;

public interface ShoppingCartState {

	void addProduct(Cart cart,Product product,int quantity);
	void removeProduct(Cart cart,Product product,int quantity);
	void checkout(Cart cart);
	void pay(Cart cart);
	void cancel(Cart cart);
	
}
