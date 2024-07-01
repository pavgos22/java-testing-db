package com.projects.rts.players;

import com.projects.rts.game.Game;
import com.projects.rts.units.Paper;
import com.projects.rts.units.Rock;
import com.projects.rts.units.Scissors;
import com.projects.rts.units.Unit;
import com.projects.rts.utils.GlobalScanner;

import java.util.Scanner;

public class Player {
    private int points = 0;

    public String getMove() {
        return move;
    }

    private String move;
    private String name;

    public void setMove(String move) {
        this.move = move;
    }

    public Player(String name) {
        this.name = name;
    }

    public void addPoints() {
        points++;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Runnable resetGameCallback;

    public void setResetGameCallback(Runnable callback) {
        this.resetGameCallback = callback;
    }

    public void resetGame() {
        if (resetGameCallback != null) {
            resetGameCallback.run();
        }
    }

    public Unit move() {
        Game.playerMoveText();
        Scanner input = GlobalScanner.getScanner();

        while (true) {
            char choice = input.nextLine().charAt(0);
            System.out.println();

            switch (choice) {
                case '1' -> {
                    move = "Rock";
                    return new Rock();
                }
                case '2' -> {
                    move = "Paper";
                    return new Paper();
                }
                case '3' -> {
                    move = "Scissors";
                    return new Scissors();
                }
                case 'x' -> {
                    while (true) {
                        System.out.println("Are you sure you want to exit the program?\nPress y(yes) or n(no)");
                        char confirmation = input.nextLine().charAt(0);

                        if (confirmation == 'y') {
                            Game.setExit(true);
                            return null;
                        } else if (confirmation == 'n') {
                            break;
                        } else {
                            System.out.println("Invalid input. Please press y or n.");
                        }
                    }
                }
                case 'n' -> {
                    resetGame();
                }
                default -> System.out.println("Invalid input. Please enter 1, 2, 3, n or x.");
            }
            Game.playerMoveText();
        }
    }
}
