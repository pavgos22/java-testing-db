package com.good.patterns.challenges.service;

public class InMemoryOrderRepository implements OrderRepository {
    @Override
    public void createOrder(User user, Product product, int quantity) {
        System.out.println("Order saved for user: " + user.getName() + ", Product: " + product.getName() + ", Quantity: " + quantity);
    }
}
