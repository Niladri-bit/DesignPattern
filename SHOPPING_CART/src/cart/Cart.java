package cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;

import entities.CartItem;
import entities.Customer;
import entities.Product;
import enumerations.CartState;
import observer.CartObservable;
import observer.CartObserver;
import state.ActiveState;
import state.ShoppingCartState;
import strategy.DiscountStrategy;

public class Cart implements CartObservable{
	private Customer customer;
	private ShoppingCartState cartState;
	private CartState cartStateEnum;
	private Map<Integer,CartItem> cartItems;
	private DiscountStrategy discountStrategy;
	List<CartObserver> observers;
	
	public Cart(Customer customer) {
		super();
		this.customer = customer;
		this.cartState = new ActiveState() ;
		this.cartStateEnum = CartState.ACTIVE;
		this.discountStrategy = null;
		this.cartItems = new HashMap<>();
		this.observers = new ArrayList<>();
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setDiscountStrategy(DiscountStrategy discountStrategy) {
		this.discountStrategy=discountStrategy;
	}


	public CartState getCartStateEnum() {
		return cartStateEnum;
	}

	public void setCartStateEnum(CartState cartStateEnum) {
		this.cartStateEnum = cartStateEnum;
	}
	
	public Map<Integer, CartItem> getCartItems() {
		return cartItems;
	}
	
	public void setCartState(ShoppingCartState cartState) {
		this.cartState = cartState;
	}

	public void addCartItem(Product product,int quantity) {
		cartState.addProduct(this, product, quantity);
	}
	
	public void removeCartItem(Product product,int quantity) {
		cartState.removeProduct(this, product, quantity);
	}
	
	public void checkout() {
		cartState.checkout(this);
	}
	
	public void pay() {
		cartState.pay(this);
		notifyObservers();
	}
	
	public void cancel() {
		cartState.cancel(this);
	}

	public String generateBill() {
	    StringBuilder bill = new StringBuilder();

	    bill.append("Item\tQty\tPrice\tTotal\n");
	    bill.append("-----------------------------------\n");

	    double grandTotal = 0;

	    for (CartItem item : cartItems.values()) {
	        String name = item.getProduct().getProductName();
	        int qty = item.getQuantity();
	        double price = item.getProduct().getPrice();
	        double total = price * qty;

	        grandTotal += total;

	        bill.append(name)
	            .append("\t")
	            .append(qty)
	            .append("\t")
	            .append(price)
	            .append("\t")
	            .append(total)
	            .append("\n");
	    }

	    bill.append("-----------------------------------\n");

	    // 🔥 Apply Discount
	    double discount = 0;
	    if (discountStrategy != null) {
	        discount = discountStrategy.calculateDiscount(new ArrayList<>(cartItems.values()));
	        bill.append("DISCOUNT: -").append(discount).append("\n");
	    }

	    double finalTotal = grandTotal - discount;

	    bill.append("TOTAL: ").append(grandTotal).append("\n");
	    bill.append("FINAL AMOUNT: ").append(finalTotal);
	    
	    return bill.toString();
	}

	@Override
	public void addObserver(CartObserver obs) {
		observers.add(obs);
		
	}

	@Override
	public void removeObserver(CartObserver obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for(CartObserver obs: observers) {
			obs.update(this);
		}
		
	}
	
	
}
