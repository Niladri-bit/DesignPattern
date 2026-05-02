package strategy;

import java.util.List;

import cart.Cart;
import entities.CartItem;
import enumerations.ProductCategory;

public class Buy1Get1DiscountStrategy implements DiscountStrategy{
	
	private final int buyCount;
	private final int getCount;
	private final ProductCategory productCategory;
	
	public Buy1Get1DiscountStrategy(int buycount,int getCount,ProductCategory productCategory) {
		this.buyCount=buycount;
		this.getCount=getCount;
		this.productCategory=productCategory;
	}

	  @Override
	    public double calculateDiscount(List<CartItem> items) {

	        double discount = 0;

	        for (CartItem item : items) {

	            // Apply only on matching category
	            if (item.getProduct().getCategory() == productCategory) {

	                int quantity = item.getQuantity();
	                double price = item.getProduct().getPrice();

	                int groupSize = buyCount + getCount;

	                // Number of complete groups
	                int eligibleGroups = quantity / groupSize;

	                // Free items
	                int freeItems = eligibleGroups * getCount;

	                discount += freeItems * price;
	            }
	        }

	        return discount;
	    }
	
}
