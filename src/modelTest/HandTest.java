package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HandTest {
	
	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	* 
	* Method: void testcountScoreLessThan21WithoutAce
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcountScoreLessThan21WithoutAce() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (10,"Ten",suit);
		Card second_card = new Card(3,"Three",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.countScore(false);
		int actual_score = actual_hand.score;
		int expected_score = 13;	
               
        assertEquals("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of Card Value",expected_score,actual_score); 
        assertFalse("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of isBusted",actual_hand.isBusted);
        assertFalse("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of isBusted",actual_hand.isBlackJack);
        
    }
	/* End Method: testdraw */
	/****************************************************************************
	* 
	* Method: void testcountScoreLessThan21WithAceLast
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcountScoreLessThan21WithAceLast() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (10,"Ten",suit);
		Card second_card = new Card(3,"Three",suit);
		Card third_card = new Card(11,"Ace",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.addCard(third_card);
		actual_hand.countScore(false);
		int actual_score = actual_hand.score;
		int expected_score = 14;	
               
        assertEquals("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of Card Value",expected_score,actual_score); 
        assertFalse("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of isBusted",actual_hand.isBusted);
        assertFalse("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of isBusted",actual_hand.isBlackJack);
        
    }
	/* End Method: testcountScoreLessThan21WithAceLast */
	/****************************************************************************
	* 
	* Method: void testcountScoreLessThan21WithAceFirst
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcountScoreLessThan21WithAceFirst() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (11,"Ace",suit);
		Card second_card = new Card(3,"Three",suit);
		Card third_card = new Card(10,"Ten",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.addCard(third_card);
		actual_hand.countScore(false);
		int actual_score = actual_hand.score;
		int expected_score = 14;	
               
        assertEquals("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of Card Value",expected_score,actual_score); 
        assertFalse("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of isBusted",actual_hand.isBusted);
        assertFalse("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of isBusted",actual_hand.isBlackJack);
        
    }
	/* End Method: testcountScoreLessThan21WithAceFirst */
	/****************************************************************************
	* 
	* Method: void testcountScoreLessThan21WithTwoAcesLast
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcountScoreLessThan21WithTwoAcesLast() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (11,"Ace",suit);
		Card second_card = new Card(3,"Three",suit);
		Card third_card = new Card(10,"Ten",suit);
		Card fourth_card = new Card(11,"Ace",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.addCard(third_card);
		actual_hand.addCard(fourth_card);
		actual_hand.countScore(false);
		int actual_score = actual_hand.score;
		int expected_score = 15;	
               
        assertEquals("Method testcountScoreLessThan21WithTwoAcesLast was unsuccessfull because of Card Value",expected_score,actual_score); 
        assertFalse("Method testcountScoreLessThan21WithTwoAcesLast was unsuccessfull because of isBusted",actual_hand.isBusted);
        assertFalse("Method testcountScoreLessThan21WithTwoAcesLast was unsuccessfull because of isBusted",actual_hand.isBlackJack);
        
    }
	/* End Method: testcountScoreLessThan21WithTwoAces */
	/****************************************************************************
	* 
	* Method: void testcountScoreLessThan21WithTwoAces
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcountScoreLessThan21WithTwoAcesFirst() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (11,"Ace",suit);
		Card second_card = new Card(3,"Three",suit);
		Card third_card = new Card(10,"Ten",suit);
		Card fourth_card = new Card(11,"Ace",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.addCard(third_card);
		actual_hand.addCard(fourth_card);
		actual_hand.countScore(false);
		int actual_score = actual_hand.score;
		int expected_score = 15;	
               
        assertEquals("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of Card Value",expected_score,actual_score); 
        assertFalse("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of isBusted",actual_hand.isBusted);
        assertFalse("Method testcountScoreLessThan21WithoutAce was unsuccessfull because of isBusted",actual_hand.isBlackJack);
        
    }
	/* End Method: testcountScoreLessThan21WithTwoAces */
	/****************************************************************************
	* 
	* Method: void testcountScoreBiggerThan21AndIsntDrawPhase
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcountScoreBiggerThan21AndIsntDrawPhase() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (10,"Ten",suit);
		Card second_card = new Card(3,"Three",suit);
		Card third_card = new Card (10,"Ten",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.addCard(third_card);
		actual_hand.countScore(false);
		int actual_score = actual_hand.score;
		int expected_score = 23;	
               
        assertEquals("Method testcountScoreBiggerThan21AndIsntDrawPhase was unsuccessfull because of Score",expected_score,actual_score);
        assertTrue("Method testcountScoreBiggerThan21AndIsntDrawPhase was unsuccessfull because of isBusted",actual_hand.isBusted);
        assertFalse("Method testcountScoreBiggerThan21AndIsntDrawPhase was unsuccessfull because of isBlackJack",actual_hand.isBlackJack);
         
    }
	/* End Method: testcountScoreBiggerThan21AndIsntDrawPhase */
	/****************************************************************************
	* 
	* Method: void testcountScoreBiggerThan21AndIsntDrawPhase
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcountScoreIs21AndIsntDrawPhase() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (10,"Ten",suit);
		Card second_card = new Card(11,"Ace",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.countScore(false);
		int actual_score = actual_hand.score;
		int expected_score = 21;	
               
        assertEquals("Method testcountScoreBiggerThan21AndIsDrawPhase was unsuccessfull because of Score",expected_score,actual_score);
        assertFalse("Method testcountScoreBiggerThan21AndIsDrawPhase was unsuccessfull because of isBusted",actual_hand.isBusted);
        assertFalse("Method testcountScoreBiggerThan21AndIsDrawPhase was unsuccessfull because of isBlackJack",actual_hand.isBlackJack);
         
    }
	/* End Method: testcountScoreBiggerThan21AndIsntDrawPhase */
	/****************************************************************************
	* 
	* Method: void testcountScoreBiggerThan21AndIsDrawPhase
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcountScoreIs21AndIsDrawPhase() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (10,"Ten",suit);
		Card second_card = new Card(11,"Ace",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.countScore(true);
		int actual_score = actual_hand.score;
		int expected_score = 21;	
               
        assertEquals("Method testcountScoreBiggerThan21AndIsDrawPhase was unsuccessfull because of Score",expected_score,actual_score);
        assertFalse("Method testcountScoreBiggerThan21AndIsDrawPhase was unsuccessfull because of isBusted",actual_hand.isBusted);
        assertTrue("Method testcountScoreBiggerThan21AndIsDrawPhase was unsuccessfull because of isBlackJack",actual_hand.isBlackJack);
         
    }
	/* End Method: testcountScoreBiggerThan21AndIsntDrawPhase */
	/****************************************************************************
	* 
	* Method: void testgetScore
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetScore() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (10,"Ten",suit);
		actual_hand.addCard(first_card);
		actual_hand.countScore(false);
		int expected_score = 10;	
               
        assertEquals("Method testgetScore was unsuccessfull because of Score",expected_score,actual_hand.getScore());
         
    }
	/* End Method: testgetScore */
	/****************************************************************************
	* 
	* Method: void testgetIsBusted
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetIsBusted() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (10,"Ten",suit);
		Card second_card = new Card(3,"Three",suit);
		Card third_card = new Card (10,"Ten",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.addCard(third_card);
		actual_hand.countScore(false);	
               
        assertTrue("Method testgetIsBusted was unsuccessfull",actual_hand.getIsBusted());
         
    }
	/* End Method: testgetIsBusted */
	/****************************************************************************
	* 
	* Method: void testgetIsBlackJack
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetIsBlackJack() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (10,"Ten",suit);
		Card second_card = new Card(11,"Ace",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.countScore(true);	
               
        assertTrue("Method testgetIsBlackJack was unsuccessfull",actual_hand.getIsBlackJack());
         
    }
	/* End Method: testgetIsBlackJack */
	/****************************************************************************
	* 
	* Method: void teststopDraw
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void teststopDraw() {
		Hand actual_hand = new Hand();	
		actual_hand.stopDraw();
               
        assertTrue("Method teststopDraw was unsuccessfull because of Score",actual_hand.stopDraw);
         
    }
	/* End Method: teststopDraw */
	/****************************************************************************
	* 
	* Method: void testcanDraw
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcanDraw() {
		Hand actual_hand = new Hand();	
               
        assertFalse("Method testcanDraw was unsuccessfull because of Score",actual_hand.canDraw());
         
    }
	/* End Method: testcanDraw */
	/****************************************************************************
	* 
	* Method: void testIsTwentyOne
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testIsTwentyOne() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (10,"Ten",suit);
		Card second_card = new Card(11,"Ace",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.countScore(false);	
               
        assertTrue("Method testIsTwentyOne was unsuccessfull because of Score",actual_hand.IsTwentyOne());
         
    }
	/* End Method: testIsTwentyOne */
	/****************************************************************************
	* 
	* Method: void testsetScoreToZero
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testsetScoreToZero() {
		Hand actual_hand = new Hand();	
        actual_hand.setScoreToZero();      
		
		assertEquals("Method testIsTwentyOne was unsuccessfull because of Score",0,actual_hand.getScore());
        assertFalse("Method testIsTwentyOne was unsuccessfull because of IsBusted",actual_hand.getIsBusted());
        assertFalse("Method testIsTwentyOne was unsuccessfull because of IsBlackJack",actual_hand.getIsBlackJack());
        assertFalse("Method testIsTwentyOne was unsuccessfull because of stopDraw",actual_hand.canDraw());
        assertFalse("Method testIsTwentyOne was unsuccessfull because of canSplit",actual_hand.getCanSplit());
        assertFalse("Method testIsTwentyOne was unsuccessfull because of canSplit",actual_hand.getStoppedThisTurn());
            
    }
	/* End Method: testsetScoreToZero */
	/****************************************************************************
	* 
	* Method: void testgetCanSplit
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetCanSplit() {
		Hand actual_hand = new Hand();	
               
        assertFalse("Method testIsTwentyOne was unsuccessfull",actual_hand.getCanSplit());
         
    }
	/* End Method: testgetCanSplit*/
	/****************************************************************************
	* 
	* Method: void testgetStoppedThisTurn
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetStoppedThisTurn() {
		Hand actual_hand = new Hand();	
               
        assertFalse("Method testgetStoppedThisTurn was unsuccessfull",actual_hand.getStoppedThisTurn());
         
    }
	/* End Method: testgetStoppedThisTurn*/
	/****************************************************************************
	* 
	* Method: void testgetaddCard
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetaddCard() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card expected_card = new Card (10,"Ten",suit);
		actual_hand.addCard(expected_card);
		       
        assertEquals("Method testgetStoppedThisTurn was unsuccessfull",expected_card,actual_hand.cards.get(0));
         
    }
	/* End Method: testgetaddCard*/
	/****************************************************************************
	* 
	* Method: void testcanSplitIsTrue
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcanSplitIsTrue() {
		Hand actual_hand = new Hand();
		Suit first_suit = new Suit ("Clubs");
		Suit second_suit = new Suit ("Diamonds");
		Card first_card = new Card (10,"Ten",first_suit);
		Card second_card = new Card (10,"Ten",second_suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.countScore(false);	
		actual_hand.canSplit();
		
        assertTrue("Method testcanSplitIsTrue was unsuccessfull",actual_hand.getCanSplit());
         
    }
	/* End Method: testcanSplitIsTrue*/
	/****************************************************************************
	* 
	* Method: void testcanSplitIsFalse
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcanSplitIsFalse() {
		Hand actual_hand = new Hand();
		Suit first_suit = new Suit ("Clubs");
		Suit second_suit = new Suit ("Diamonds");
		Card first_card = new Card (10,"King",first_suit);
		Card second_card = new Card (10,"Ten",second_suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.countScore(false);	
		actual_hand.canSplit();
		
        assertFalse("Method testcanSplitIsFalse was unsuccessfull",actual_hand.getCanSplit());
         
    }
	/* End Method: testcanSplitIsFalse*/
	/****************************************************************************
	* 
	* Method: void teststop
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void teststop() {
		Hand actual_hand = new Hand();
		actual_hand.stop();
		       
        assertTrue("Method testgetStoppedThisTurn was unsuccessfull",actual_hand.getStoppedThisTurn());
         
    }
	/* End Method: teststop*/
	/****************************************************************************
	* 
	* Method: void testclear
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testclear() {
		Hand actual_hand = new Hand();
		actual_hand.clear();
		int expected_score = 0;
		       
        assertEquals("Method testgetStoppedThisTurn was unsuccessfull",expected_score,actual_hand.getScore());
         
    }
	/* End Method: testclear*/

}
