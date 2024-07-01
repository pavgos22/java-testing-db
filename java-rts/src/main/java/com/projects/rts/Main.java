package com.projects.rts;

import com.projects.rts.game.Game;
import com.projects.rts.players.Computer;
import com.projects.rts.players.Player;
import com.projects.rts.utils.GlobalScanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = GlobalScanner.getScanner();
        System.out.print("Enter username: ");

        String playerName = input.nextLine();
        Player player = new Player(playerName);
        Computer computer = new Computer();
        Game game = new Game(player, computer);
        System.out.println();

        boolean shouldRun = true;
        do {
            game.calculateMove(computer.move());
            if ((player.getMove().equals(null) || player.getMove().equals("")) && Game.isExit()) {
                shouldRun = false;
            }
        } while (shouldRun);
        GlobalScanner.closeScanner();
    }
}