// Ariel Mileguir
// Pedro Gabriel 

package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AbstractPlayerTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	 * 
	 * Method: void testisBroke
	 *  ****/	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testisBroke() {
        Hand actual_hand = new Hand();
        actual_hand.isBusted = true;
        AbstractPlayer actual_player = new AbstractPlayer("playername");
        
        assertTrue("Method isBroke was unsuccessfull",actual_player.isBroke(actual_hand));

    }
	/* End Method: testisBroke */
	/*
	****************************************************************************
	 * 
	 * Method: testTakeCardWhenIsPlayingAndHandIsEmpty: Test
	 * case when the player is playing and his hand is empty
	 *  ****/
	
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testTakeCardWhenIsPlayingAndHandIsEmpty() {
		AbstractPlayer actual_player = new AbstractPlayer("playername");
		Card actual_card = new Card(2, "dois", new Suit("Clubs"));
		Hand actual_hand = new Hand();
		
		actual_player.isPlaying = true;
		actual_player.takeCard(actual_card, actual_hand);
		assertEquals("Method takecard was unsuccessfull",actual_card,actual_hand.cards.get(0));
		
	}  
	
	/* End Method: testTakeCardWhenIsPlayingAndHandIsEmpty */
	/*
	****************************************************************************
	 * 
	 * Method: void testTakeCardWhenIsPlayingAndHandIsBroke: Test
	 * case when the player is playing and his hand is broke
	 *  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testTakeCardWhenIsPlayingAndHandIsBroke() {
		AbstractPlayer actual_player = new AbstractPlayer("playername");
		Card actual_card1 = new Card(10, "dez", new Suit("Clubs"));
		Card actual_card2 = new Card(10, "dez", new Suit("Diamonds"));
		Card actual_card3 = new Card(10, "dez", new Suit("Hearts"));
		Card actual_card4 = new Card(10, "dez", new Suit("Spades"));
		Hand actual_hand = new Hand();
		int expected = 3;
		
		actual_player.isPlaying = true;
		actual_hand.cards.insertL(actual_card1);
		actual_hand.cards.insertL(actual_card2);
		actual_hand.cards.insertL(actual_card3);
		
		actual_hand.countScore(true);
		
		actual_player.takeCard(actual_card4, actual_hand);
		
		assertEquals("Method takecard was unsuccessfull",expected,actual_hand.cards.size);
		
	}
	
	/* End Method: testTakeCardWhenIsPlayingAndHandIsBroke */
	/*
	****************************************************************************
	 * 
	 * Method: void testTakeCardWhenIsNotPlayingAndHandIsNotBroke: Test
	 * case when the player isn't playing and his hand isn't broke
	 *  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testTakeCardWhenIsNotPlayingAndHandIsNotBroke() {
		AbstractPlayer actual_player = new AbstractPlayer("playername");
		Card actual_card = new Card(10, "dez", new Suit("Clubs"));
		Hand actual_hand = new Hand();
		int expected = 0;
		
		actual_player.isPlaying = false;
		
		actual_player.takeCard(actual_card, actual_hand);
		
		assertEquals("Method takecard was unsuccessfull",expected,actual_hand.cards.size);
		
	}
	
	/* End Method: testTakeCardWhenIsNotPlayingAndHandIsNotBroke */
	/*
	****************************************************************************
	 * 
	 * Method: void testTakeCardWhenIsNotPlayingAndHandIsBroke: Test
	 * case when the player isn't playing and his hand is broke
	 *  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testTakeCardWhenIsNotPlayingAndHandIsBroke() {
		AbstractPlayer actual_player = new AbstractPlayer("playername");
		Card actual_card1 = new Card(10, "dez", new Suit("Clubs"));
		Card actual_card2 = new Card(10, "dez", new Suit("Diamonds"));
		Card actual_card3 = new Card(10, "dez", new Suit("Hearts"));
		Card actual_card4 = new Card(10, "dez", new Suit("Spades"));
		Hand actual_hand = new Hand();
		int expected = 3;
		
		actual_player.isPlaying = false;
		actual_hand.cards.insertL(actual_card1);
		actual_hand.cards.insertL(actual_card2);
		actual_hand.cards.insertL(actual_card3);
		
		actual_hand.countScore(false);
		
		actual_player.takeCard(actual_card4, actual_hand);
		
		assertEquals("Method takecard was unsuccessfull",expected,actual_hand.cards.size);
		
	}
	
	/* End Method: testTakeCardWhenIsNotPlayingAndHandIsBroke */
	/*
	****************************************************************************
	* 
	* Method: void testStand
	*  ****/
      	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testStand() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        actual.isPlaying = true;
        
        actual.endTurn();
        assertFalse("Method Stand was unsuccessfull",actual.isPlaying);

    }
	
	/* End Method: testStand */
	/*
	****************************************************************************
	* 
	* Method: void testGetName
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetName() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        
        
        assertTrue("Method getName was unsuccessfull",actual.getName() == "playername");

    }
	
	/* End Method: testGetName */
	/*
	****************************************************************************
	* 
	* Method: testPlayerTurn
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testPlayerTurn() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        actual.isPlaying = false;
        
        actual.playerTurn();
        assertTrue("Method PlayerTurn was unsuccessfull",actual.isPlaying);

    }
	
	/* End Method: testPlayerTurn */
	/*
	****************************************************************************
	* 
	* Method: void testgetIsPlaying
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetIsPlaying() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        actual.isPlaying = false;
      
        
        assertTrue("Method getIsPlaying was unsuccessfull",actual.getIsPlaying() == false);

    }
	
	/* End Method: getIsPlaying */
	/*
	****************************************************************************
	* 
	* Method: void testEndTurn
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testEndTurn() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        actual.isPlaying = true;
        
        actual.endTurn();
        assertFalse("Method End Turn was unsuccessfull",actual.isPlaying);

    }
	
	/* End Method: endTurn */
	/*
	****************************************************************************
	* 
	* Method: void testgetHands
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetHands() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        
        assertEquals("Method getHands was unsuccessfull",actual.hands,actual.getHands());

    }
	
	/* End Method: testgetHands */
	/*
	****************************************************************************
	* 
	* Method: void testprepareNextTurn
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testprepareNextTurn() {
        AbstractPlayer actual_player = new AbstractPlayer("playername");
        Hand actual_hand = new Hand();
        Card expected_card = new Card(10, "dez", new Suit("Clubs"));
        
        actual_hand.cards.insertL(expected_card);
        actual_player.hands.insertL(actual_hand);
        
        assertEquals("Method getHands was unsuccessfull",expected_card,actual_player.prepareNextTurn().get(0));

    }
	
	/* End Method: testprepareNextTurn */
	/*
	****************************************************************************
	* 
	* Method: void testTurnWinner
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testTurnWinner() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        
        actual.turnWinner();
        
        assertTrue("Method turnWinner was unsuccessfull",actual.isTurnWinner);

    }
	
	/* End Method: testTurnWinner */
	/*
	****************************************************************************
	* 
	* Method: void testisTurnWinner
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testisTurnWinner() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        actual.isTurnWinner = true;
        
        
        assertTrue("Method isTurnWinner was unsuccessfull",actual.isTurnWinner() == true);

    }
	
	/* End Method: testisTurnWinner */	
	
}