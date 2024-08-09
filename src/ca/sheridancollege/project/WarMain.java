package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * @author saranya
 * @author navdeep
 * @author roshan
 *
 * A class that contains the main method to run the War game.
 */
public class WarMain {

    public static void main(String[] args) {
        // Prompt players to register
        try (Scanner input = new Scanner(System.in)) {
            // Prompt players to register
            System.out.print("Enter name for Player 1: ");
            String player1Name = input.nextLine();
            
            System.out.print("Enter name for Player 2: ");
            String player2Name = input.nextLine();
            
            int roundLimit = 10; // Set the round limit
            WarGame warGame = new WarGame(player1Name, player2Name, roundLimit);
            warGame.play();
            warGame.declareWinner();
        }
    }
}

