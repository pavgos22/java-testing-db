package com.good.patterns.challenges.service;

public interface OrderRepository {
    void createOrder(User user, Product product, int quantity);
}
