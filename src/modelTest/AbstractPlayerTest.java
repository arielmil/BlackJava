package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AbstractPlayerTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	
		
	

	
	
	/*Verificar testTakeCard
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testTakeCard() {
        
        
        /*Caso com a mão não quebrada e não jogando*/
        /*Caso com a mão quebrada e jogando*/
        /*Caso com a mão não quebrada e não jogando*/
        /*Caso com a mão quebrada e jogando*/
        

   // }
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testStand() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        actual.isPlaying = true;
        
        actual.endTurn();
        assertFalse("Method Stand was unsuccessfull",actual.isPlaying);

    }
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetName() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        
        
        assertTrue("Method getName was unsuccessfull",actual.getName() == "playername");

    }
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testPlayerTurn() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        actual.isPlaying = false;
        
        actual.playerTurn();
        assertTrue("Method PlayerTurn was unsuccessfull",actual.isPlaying);

    }
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetIsPlaying() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        actual.isPlaying = false;
      
        
        assertTrue("Method getIsPlaying was unsuccessfull",actual.getIsPlaying() == false);

    }
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testEndTurn() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        actual.isPlaying = true;
        
        actual.endTurn();
        assertFalse("Method End Turn was unsuccessfull",actual.isPlaying);

    }
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetHands() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        
        assertEquals("Method getHands was unsuccessfull",actual.hands,actual.getHands());

    }
	
	/* Verificar testPrepareNextTurn
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testprepareNextTurn() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        
        assertEquals("Method getHands was unsuccessfull",actual.hands,actual.getHands());

    }*/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testTurnWinner() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        
        actual.turnWinner();
        
        assertTrue("Method turnWinner was unsuccessfull",actual.isTurnWinner);

    }
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testisTurnWinner() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        actual.isTurnWinner = true;
        
        
        assertTrue("Method isTurnWinner was unsuccessfull",actual.isTurnWinner() == true);

    }
	
}