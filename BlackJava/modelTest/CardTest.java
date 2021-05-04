package modelTest;

import model.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardTest {

    @Test
    public void testGetValueReturnsExpectedValue() {
        Card card = new Card(2, "dois", new Suit("Clubs"));

        assertEquals(2, card.getValue());
    }
    
    @Test
    public void testSetValueReturnsExpectedValue() {
        Card card = new Card(2, "dois", new Suit("Clubs"));

        card.setValue(5);
        assertEquals(5, card.getValue());
    
    }
    
    @Test
    public void testGetNameReturnsExpectedName() {
        Card card = new Card(2, "dois", new Suit("Clubs"));

        assertEquals("dois", card.getName());
    }
    
    @Test
    public void testGetRevealedReturnsExpectedValue() {
        Card card = new Card(2, "dois", new Suit("paus"));

        assertFalse(card.getRevealed());
        card.reveal();
        assertTrue(card.getRevealed());
    }
    
    @Test
    public void testGetSuitReturnsExpectedSuit() {
        Suit suit = new Suit("Clubs");
        Card card = new Card(2, "dois", suit);

        assertEquals(suit,card.getSuit());
    }

    @Test
    public void testGetNameSuitReturnsExpectedSuit() {
        Suit suit = new Suit("Clubs");
        Card card = new Card(2, "dois", suit);

        assertEquals(card.getSuitname(), suit.getName());
    }

    
}