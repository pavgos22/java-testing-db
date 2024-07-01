package com.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(1.5, 2);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            System.out.println("This block is always executed");
        }
    }
}