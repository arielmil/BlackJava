// Ariel Mileguir
// Pedro Gabriel 

package modelTest;

import model.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DealerTest {
	
	private static final int DEFAULT_TIMEOUT = 5000;
	
	
	/****************************************************************************
	* 
	* Method: void testcheckIsTen:
	*  ****/
	/*
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcheckIsTenIsTrueForCardTen() {
        Dealer actual = new Dealer ();
        AbstractPlayer Player = new AbstractPlayer("Pedro");
        Suit actual_suit = new Suit("Clubs");
        Card Ten = new Card (10,"Ten",actual_suit);
        Player.hands.insertL(Ten);    
          
        
        assertTrue("Method setIsTen for true was unsuccessfull",checkIsTen(Player));
    }*/

	/* End Method: testcheckIsTenIsTrue */
	/****************************************************************************
	* 
	* Method: void testsetIsTenIsTrue: Tests the case if the boolean parameter is true
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testsetIsTenIsTrue() {
        Dealer actual = new Dealer ();
        
        actual.setIsTen(true);
        assertTrue("Method setIsTen for true was unsuccessfull",actual.FirstDrawIsTen);

    }

	/* End Method: testsetIsTenIsTrue */
	/*
	****************************************************************************
	* 
	* Method: void testsetIsTenIsFalse: Tests the case if the boolean parameter is false
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testsetIsTenIsFalse() {
        Dealer actual = new Dealer ();
               
        actual.setIsTen(false);
        assertFalse("Method setIsTen for false was unsuccessfull",actual.FirstDrawIsTen);

    }
	
	/* End Method: testsetIsTenIsFalse */
	/*
	****************************************************************************
	* 
	* Method: void testgetIsTen
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetIsTen() {
        Dealer actual_dealer = new Dealer ();
               
        assertFalse("Method getIsTen was unsuccessfull",actual_dealer.FirstDrawIsTen);

    }
	
	/* End Method: testsetIsTenIsFalse */
	/*
	****************************************************************************
	* 
	* Method: void testdeal
	*  ****/
	/*
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testdeal() {
        Dealer actual_dealer = new Dealer ();
        AbstractPlayer actual_player = new AbstractPlayer("Pedro");
        Hand actual_hand = new Hand();
		Deck actual_deck = new Deck();
        actual_deck.shuffle();
        actual_dealer.deal(actual_player,actual_hand,actual_deck);
        actual_dealer.deal(actual_player,actual_hand,actual_deck);
        int size = actual_player.hands.getSize();    
               
        assertEquals("Method getIsTen was unsuccessfull",2,size);
    }*/
	
	/* End Method: testsetIsTenIsFalse */

}