package observer;


import cart.Cart;

public interface CartObserver {
    void update(Cart cart);
}