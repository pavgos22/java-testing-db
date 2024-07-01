package com.patterns.strategy.social;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Using Facebook";
    }
}
