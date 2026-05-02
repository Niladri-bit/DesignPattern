package observer;

import cart.Cart;

public class AnalyticsObserver implements CartObserver{

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		 System.out.println("Analytics being sent " +cart.getCustomer());
	}

}
