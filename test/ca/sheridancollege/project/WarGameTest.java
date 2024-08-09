package ca.sheridancollege.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarGameTest {

    private WarGame warGame;

    @BeforeEach
    public void setUp() {
        warGame = new WarGame("saranya", "navdeep", 10);
    }

    @Test
    public void testPlayRoundGood() {
        String result = warGame.playRound();
        assertTrue(result.contains("wins the round!") || result.equals("It's a tie!"));
    }

    @Test
    public void testPlayRoundGameOver() {
        for (int i = 0; i < 26; i++) {
            warGame.playRound();
        }
        String result = warGame.playRound();
        assertEquals("Game Over", result);
    }

    @Test
    public void testDeclareWinnerGood() {
        // Force a winner by removing cards from player2
        warGame.getPlayer2().getHand().getCards().clear();
        String result = warGame.declareWinner();
        assertTrue(result.contains("saranya wins the game!"));
    }

    @Test
    public void testDeclareWinnerTie() {
        // Force a tie by making both players have the same number of cards
        warGame.getPlayer1().getHand().getCards().clear();
        warGame.getPlayer2().getHand().getCards().clear();
        String result = warGame.declareWinner();
        assertEquals("It's a tie!", result);
    }
}
