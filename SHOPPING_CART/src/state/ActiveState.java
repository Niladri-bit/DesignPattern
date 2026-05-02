package state;

import java.util.Map;

import cart.Cart;
import entities.CartItem;
import entities.Product;
import enumerations.CartState;

public class ActiveState implements ShoppingCartState{

	@Override
	public void addProduct(Cart cart, Product product,int quantity) {
		Map<Integer,CartItem> cartItems = cart.getCartItems();
		if(cartItems.containsKey(product.getProductId())) {
			CartItem p = cartItems.get(product.getProductId());
			if(p.getQuantity() + quantity > product.getMaxQuantity()) {
				System.out.println("You can't have max " + product.getMaxQuantity() +" "+ product.getProductName());
			}
			else {
				  p.setQuantity(p.getQuantity() + quantity);
			}
			
		}else {
			if(quantity>product.getMaxQuantity()) {
				System.out.println("You can't have max " + product.getMaxQuantity() +" "+ product.getProductName());
			}else {
				cartItems.put(product.getProductId(), new CartItem(product,quantity));
			}
		}
		
	}

	@Override
	public void removeProduct(Cart cart, Product product,int quantity) {
		Map<Integer,CartItem> cartItems = cart.getCartItems();
		if(cartItems.containsKey(product.getProductId())) {
			CartItem p = cartItems.get(product.getProductId());
			if(p.getQuantity() - quantity <0) {
				System.out.println("You can't remove " + quantity +" "+ product.getProductName() +" you have only "+ p.getQuantity());
			}
			else {
				  int newQty =  p.getQuantity() - quantity;
				  if (newQty == 0) {
					    cartItems.remove(product.getProductId());
					} else {
					    p.setQuantity(newQty);
					}
			}
			
		}else {
				System.out.println("You don't have this product: " + product.getProductName());
			
		}
		
	}

	@Override
	public void checkout(Cart cart) {
		if (cart.getCartItems().isEmpty()) {
			System.out.println("Cart is empty");
		}else {
			cart.setCartStateEnum(CartState.CHECKED_OUT);
			System.out.println("Cart checked out");
			cart.setCartState(new CheckedOutState());
		}
	}

	@Override
	public void pay(Cart cart) {
		// TODO Auto-generated method stub
		System.out.println("Cart can't be paid before checkout");
		
	}

	@Override
	public void cancel(Cart cart) {
		cart.setCartStateEnum(CartState.CANCELED);
		cart.setCartState(new CanceledState());
		System.out.println("Cart canceled");
		
		
	}
	
}
