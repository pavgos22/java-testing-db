package com.good.patterns.challenges.service;

public class SimpleOrderService implements OrderService {
    @Override
    public boolean order(User user, Product product, int quantity) {
        System.out.println("Order placed for user: " + user.getName() + ", Product: " + product.getName() + ", Quantity: " + quantity);
        return true;
    }
}
