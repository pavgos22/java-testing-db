package com.spring.javaspring.forum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class ForumUserTestSuite {
    @Test
    void testGetUserName() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.spring.javaspring");
        ForumUser user = context.getBean(ForumUser.class);

        assertEquals("John Smith", user.getUsername());
    }
}
