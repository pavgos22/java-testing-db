package com.good.patterns.challenges.service;

public class OrderDTO {
    private User user;
    private boolean isOrdered;

    public OrderDTO(User user, boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
