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
        int expected = 2;

        assertEquals("Method getValue didn't worked sucessfully",expected, actual.getValue());
    }
    
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testSetValueReturnsExpectedValue() {
        Card actual = new Card(2, "dois", new Suit("Clubs"));
        int expected = 5;
        
        actual.setValue(expected);
        assertEquals("Method setValue didn't worked sucessfully",expected, actual.getValue());
    
    }
    
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetNameReturnsExpectedName() {
        Card actual = new Card(2, "dois", new Suit("Clubs"));

        assertEquals("Method getName didn't worked sucessfully","dois", actual.getName());
    }
    
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testToggleRevealExpectedValue() {
        Card actual = new Card(2, "dois", new Suit("Clubs"));

        assertFalse(actual.getRevealed());
        actual.toggleReveal();
        assertTrue("Method getRevealed didn't worked sucessfully",actual.getRevealed());
    }
    
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetSuitReturnsExpectedSuit() {
        Suit expected = new Suit("Clubs");
        Card actual = new Card(2, "dois", expected);

        assertEquals("Method getSuit didn't worked sucessfully",expected,actual.getSuit());
    }

	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetNameSuitReturnsExpectedSuit() {
        Suit actual = new Suit("Clubs");
        Card expected = new Card(2, "dois", actual);

        assertEquals("Method getSuitName didn't worked sucessfully",expected.getSuitname(), actual.getName());
    }

	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetRevealedExpectedValue() {
        Card actual = new Card(2, "dois", new Suit("Clubs"));

        assertFalse("Method getRevealed didn't worked sucessfully",actual.getRevealed());

    }
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testEquals() {
        Card actual = new Card(2, "dois", new Suit("Clubs"));
        Card expected = new Card(2, "dois", new Suit("Clubs"));
        
        assertTrue("Method equals didn't worked sucessfully",expected.equals(actual));
   
    }
}