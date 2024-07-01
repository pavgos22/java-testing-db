package com.projects.rts.game;

import com.projects.rts.players.Computer;
import com.projects.rts.players.Player;
import com.projects.rts.units.Unit;
import com.projects.rts.utils.GlobalScanner;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Computer computer;

    private static boolean exit = false;

    public static boolean isExit() {
        return exit;
    }

    public static void setExit(boolean exit) {
        Game.exit = exit;
    }

    public Game(Player player1, Computer computer) {
        this.player1 = player1;
        this.computer = computer;

        player1.setResetGameCallback(this::resetGame);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void playerMoveText() {
        System.out.print("Enter your move (1 for Rock, 2 for Paper, 3 for Scissors, n for new game, x to exit): ");
    }

    public void moveText () {
        System.out.println(player1.getName() + ": " + player1.getMove());
        System.out.println(computer.getName() + ": " + computer.getMove());
    }

    public void calculateMove (Unit computerMove) {
        Integer moveResult = player1.move().beats(computerMove);
        switch (moveResult) {
            case -1 -> lose();
            case 0 -> draw();
            case 1 -> win();
        };
    }

    public void score() {
        moveText();
        System.out.println("*****Score*****");
        System.out.println(player1.getName() + ": [" + player1.getPoints() + "]");
        System.out.println(computer.getName() + ": [" + computer.getPoints() + "]");
    }

    public void win() {
        System.out.println(player1.getName() + " wins!");
        player1.addPoints();
        score();
    }

    public void draw() {
        System.out.println("Draw!");
        score();
    }

    public void lose() {
        System.out.println(computer.getName() + " wins");
        computer.addPoints();
        score();
    }

    public void resetGame() {
        Scanner input = GlobalScanner.getScanner();
        player1.setPoints(0);
        computer.setPoints(0);
        clearScreen();
        System.out.print("Creating new game\nEnter new username: ");
        player1.setName(input.nextLine());
    }
}
