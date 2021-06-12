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
	* Method: void countScoreLessThan21
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testcountScoreLessThan21() {
		Hand actual_hand = new Hand();
		Suit suit = new Suit ("Clubs");
		Card first_card = new Card (10,"Ten",suit);
		Card second_card = new Card(3,"Three",suit);
		actual_hand.addCard(first_card);
		actual_hand.addCard(second_card);
		actual_hand.countScore(false);
		int actual_score = actual_hand.score;
		int expected_score = 13;	
               
        assertEquals("Method countScoreLessThan21 was unsuccessfull because of Card Value",expected_score,actual_score); 
        assertFalse("Method testcountScoreBiggerThan21AndIsntDrawPhase was unsuccessfull because of isBusted",actual_hand.isBusted);
        assertFalse("Method testcountScoreBiggerThan21AndIsntDrawPhase was unsuccessfull because of isBusted",actual_hand.isBlackJack);
        
    }
	/* End Method: testdraw */
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
	

}
