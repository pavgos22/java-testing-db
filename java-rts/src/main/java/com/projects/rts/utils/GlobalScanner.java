package com.projects.rts.utils;

import java.util.Scanner;

public class GlobalScanner {
    private static Scanner scanner;

    private GlobalScanner() {

    }

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}