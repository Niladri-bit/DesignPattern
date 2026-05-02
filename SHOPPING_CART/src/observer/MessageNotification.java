package observer;

import cart.Cart;

public class MessageNotification implements CartObserver{

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		 System.out.println("Message sent to customer: "+cart.getCustomer().getName());
	}

}
