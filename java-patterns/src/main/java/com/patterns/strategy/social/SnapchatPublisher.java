package com.patterns.strategy.social;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Using Snapchat";
    }
}
