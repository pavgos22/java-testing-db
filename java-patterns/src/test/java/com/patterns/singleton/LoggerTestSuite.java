package com.patterns.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    public void testSingletonLoggerLastLog() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        logger1.log("Log from logger1");
        logger2.log("Log from logger2");
        logger3.log("Log from logger3");

        assertEquals("Log from logger3", logger1.getLastLog());
    }
}
