package com.patterns.strategy.social;

public class Millenials extends User {
    public Millenials(String username) {
        super(username);
        this.socialPublisher = new FacebookPublisher();
    }
}
