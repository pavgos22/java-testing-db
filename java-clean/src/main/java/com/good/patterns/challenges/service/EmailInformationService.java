package com.good.patterns.challenges.service;

public class EmailInformationService implements InformationService {
    @Override
    public void inform(User user, boolean orderStatus) {
        String message = orderStatus ? "Order successfully placed!" : "Order failed!";
        System.out.println("Email sent to " + user.getEmail() + ": " + message);
    }
}
