package cart;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cart.Cart;
import entities.Customer;
import enumerations.CartState;

public class ShoppingCartService {

    // 🔥 Thread-safe Singleton (eager initialization)
    private static final ShoppingCartService INSTANCE = new ShoppingCartService();

    // 🔥 One cart per customer
    private Map<Integer, Cart> carts;

    private ShoppingCartService() {
        carts = new ConcurrentHashMap<>();
    }

    public static ShoppingCartService getInstance() {
        return INSTANCE;
    }

    // 🔹 Create new cart with lifecycle check
    public Cart createCart(Customer customer) {

        Cart existingCart = carts.get(customer.getCustomerId());

        if (existingCart != null) {
            CartState state = existingCart.getCartStateEnum();

            // ❌ Do NOT allow new cart if active or in checkout
            if (state == CartState.ACTIVE || state == CartState.CHECKED_OUT) {
                throw new RuntimeException("User already has an active cart");
            }
        }

        // ✅ Create new cart
        Cart newCart = new Cart(customer);
        carts.put(customer.getCustomerId(), newCart);

        return newCart;
    }

    // 🔹 Get existing cart (if any)
    public Cart getCart(Customer customer) {
        return carts.get(customer.getCustomerId());
    }

    // 🔹 Get or create (useful helper)
    public Cart getOrCreateCart(Customer customer) {
        Cart cart = carts.get(customer.getCustomerId());

        if (cart == null) {
            return createCart(customer);
        }

        return cart;
    }

    // 🔹 Remove cart after completion (optional cleanup)
    public void removeCart(Customer customer) {
        carts.remove(customer.getCustomerId());
    }
}