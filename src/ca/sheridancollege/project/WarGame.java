package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * @auther saranya, navdeep, roshan
 * A class that models the War card game.
 */
public class WarGame {

    private final GroupOfCards deck;
    private final Player player1;
    private final Player player2;
    private final int roundLimit;
    private int currentRound;

    public WarGame(String player1Name, String player2Name, int roundLimit) {
        this.deck = new GroupOfCards();
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.roundLimit = roundLimit;
        this.currentRound = 0;
        initializeDeck();
        deck.shuffle();
        dealCards();
    }

    // Getter methods for player1 and player2
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.addCard(new Card(suit, rank));
            }
        }
    }

    private void dealCards() {
        ArrayList<Card> deckCards = deck.getCards();
        for (int i = 0; i < deckCards.size(); i++) {
            if (i % 2 == 0) {
                player1.getHand().addCard(deckCards.get(i));
            } else {
                player2.getHand().addCard(deckCards.get(i));
            }
        }
    }

    public String playRound() {
        if (!player1.getHand().isEmpty() && !player2.getHand().isEmpty() && currentRound < roundLimit) {
            currentRound++;
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();
            if (card1.getRank().compareTo(card2.getRank()) > 0) {
                player1.getHand().addCard(card1);
                player1.getHand().addCard(card2);
                return player1.getName() + " wins the round!";
            } else if (card1.getRank().compareTo(card2.getRank()) < 0) {
                player2.getHand().addCard(card1);
                player2.getHand().addCard(card2);
                return player2.getName() + " wins the round!";
            } else {
                return "It's a tie!";
            }
        }
        return "Game Over";
    }

    public String declareWinner() {
        if (player1.getHand().getSize() > player2.getHand().getSize()) {
            return player1.getName() + " wins the game!";
        } else if (player2.getHand().getSize() > player1.getHand().getSize()) {
            return player2.getName() + " wins the game!";
        } else {
            return "It's a tie!";
        }
    }
}
