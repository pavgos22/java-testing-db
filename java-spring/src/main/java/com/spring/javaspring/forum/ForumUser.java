package com.spring.javaspring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {
    public String getUsername() {
        return username;
    }

    private String username;

    public ForumUser() {
        username = "John Smith";
    }
}
