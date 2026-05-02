package client;


import cart.Cart;
import cart.ShoppingCartService;
import entities.Customer;
import entities.Product;
import enumerations.ProductCategory;
import observer.EmailNotificationObserver;
import observer.MessageNotification;
import strategy.Buy1Get1DiscountStrategy;
import strategy.PercentageDiscountStrategy;


public class Client {

    public static void main(String[] args) {

        // 🔹 Create customer
        Customer customer = new Customer(1, "John","john@gmail.com");

        // 🔹 Create products
        Product laptop = new Product(101, "Laptop",10, 50000f, ProductCategory.ELECTRONICS);
        Product mouse = new Product(102, "Mouse", 20,500f, ProductCategory.ELECTRONICS);

        // 🔹 Get cart service
        ShoppingCartService cartService = ShoppingCartService.getInstance();

        // 🔹 Create cart
        Cart cart = cartService.createCart(customer);
        cart.addObserver(new EmailNotificationObserver());
        cart.addObserver(new MessageNotification());
        // 🔹 Add items
        cart.addCartItem(laptop, 1);
        cart.addCartItem(mouse, 4);

        // 🔹 Remove item
        cart.removeCartItem(mouse, 1);
        cart.setDiscountStrategy(new Buy1Get1DiscountStrategy(1, 1, ProductCategory.ELECTRONICS)); // 10% discount
        // 🔹 Checkout
        cart.checkout();

        // 🔹 Pay
        cart.pay();

        // 🔹 Print bill
        System.out.println(cart.generateBill());

        // 🔹 Remove cart after completion (optional cleanup)
        cartService.removeCart(customer);

        // 🔹 Create new cart after payment (allowed)
        Cart newCart = cartService.createCart(customer);
        newCart.addCartItem(mouse, 3);

        System.out.println("\nNew Cart Bill:");
        System.out.println(newCart.generateBill());
    }
}