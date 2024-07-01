package com.exception.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecondChallengeTestSuite {
    @Test
    void testProbablyIWillThrowExceptionWithValidValues() {
        SecondChallenge secondChallenge = new SecondChallenge();
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 2));
    }

    @Test
    void testProbablyIWillThrowExceptionWithInvalidValues() {
        SecondChallenge secondChallenge = new SecondChallenge();
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1.5));
    }

    @Test
    void testProbablyIWillThrowExceptionWithBoundaryValues() {
        SecondChallenge secondChallenge = new SecondChallenge();
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1, 1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 1.4))
        );
    }
}