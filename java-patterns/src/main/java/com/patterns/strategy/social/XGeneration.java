package com.patterns.strategy.social;

public class XGeneration extends User {
    public XGeneration(String username) {
        super(username);
        this.socialPublisher = new TwitterPublisher();
    }
}
