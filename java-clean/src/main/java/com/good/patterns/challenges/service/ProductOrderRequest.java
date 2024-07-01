package com.good.patterns.challenges.service;

public class ProductOrderRequest {
    private User user;
    private Product product;
    private int quantity;

    public ProductOrderRequest(User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
