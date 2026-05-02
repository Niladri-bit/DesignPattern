package observer;

import cart.Cart;

public class EmailNotificationObserver implements CartObserver{

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		 System.out.println("Email sent to customer: " +cart.getCustomer().getEmailId());
	}

}
