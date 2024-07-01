package com.patterns.strategy.social;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Using Twitter";
    }
}
