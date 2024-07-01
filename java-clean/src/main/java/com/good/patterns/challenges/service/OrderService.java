package com.good.patterns.challenges.service;

public interface OrderService {
    boolean order(User user, Product product, int quantity);
}
