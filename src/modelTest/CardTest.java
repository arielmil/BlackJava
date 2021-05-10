package modelTest;

import model.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetValueReturnsExpectedValue() {
        Card actual = new Card(2, "dois", new Suit("Clubs"));
        

        assertEquals(2, actual.getValue());
    }
    
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testSetValueReturnsExpectedValue() {
        Card actual = new Card(2, "dois", new Suit("Clubs"));

        actual.setValue(5);
        assertEquals(5, actual.getValue());
    
    }
    
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetNameReturnsExpectedName() {
        Card actual = new Card(2, "dois", new Suit("Clubs"));

        assertEquals("dois", actual.getName());
    }
    
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetRevealedReturnsExpectedValue() {
        Card actual = new Card(2, "dois", new Suit("paus"));

        assertFalse(actual.getRevealed());
        actual.toggleReveal();
        assertTrue(actual.getRevealed());
    }
    
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetSuitReturnsExpectedSuit() {
        Suit expected = new Suit("Clubs");
        Card actual = new Card(2, "dois", expected);

        assertEquals(expected,actual.getSuit());
    }

	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetNameSuitReturnsExpectedSuit() {
        Suit actual = new Suit("Clubs");
        Card expected = new Card(2, "dois", actual);

        assertEquals(expected.getSuitname(), actual.getName());
    }

    
}