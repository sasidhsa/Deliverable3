/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * @auther saranya, navdeep, roshan
 */
package ca.sheridancollege.project;

/**
 * A class to represent a playing card.
 */
public class Card {

    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
