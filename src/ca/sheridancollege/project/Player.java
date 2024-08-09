/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * @auther saranya, navdeep, roshan
 *
 * A class that models each Player in the War game.
 */
public class Player {

    private final String name;
    private GroupOfCards hand;

    public Player(String name) {
        this.name = name;
        hand = new GroupOfCards();
    }

    public String getName() {
        return name;
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }

    public Card playCard() {
        return hand.removeTopCard();
    }
}
