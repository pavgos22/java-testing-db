package com.exception.test;

public class RouteNotFoundException extends Exception {
    public RouteNotFoundException(String message) {
        super(message);
    }
}