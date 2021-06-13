package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class PlayerTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	* 
	* Method: void testGetIsElevenChangesValue
	*  ****/
	/*
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testaddTokens() {
        Player actual_player = new Player("Player");
        List actual_token_list = new List();
        actual_token_list.insertL(new Tokens("Red",3));
        actual_token_list.insertL(new Tokens("Blue",2));
        actual_player.addTokens(actual_token_list);
        
        int expected_money = 80;
          
        assertEquals("Method testaddTokens was unsuccessfull", expected_money,actual_player.getTotalMoney()); 

    }*/
    
    /* End Method: testIsInsuranceIsInitiallyFalse */
	/****************************************************************************
	* 
	* Method: void testGetInsurance
	*  ****/
	
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testgetInsurance() {
        Player actual_player = new Player("Player");
          
        assertFalse("Method testgetInsurance was unsuccessfull", actual_player.getInsurance()); 

    }
    
    /* End Method: testGetInsurance */
    /****************************************************************************
	* 
	* Method: void testEndTurn
	*  ****/
	
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testEndTurn() {
        Player actual_player = new Player("Player");
        actual_player.endTurn();
         
        assertFalse("Method testgetInsurance was unsuccessfull", actual_player.getInsurance()); 

    }
    
    /* End Method: testEndTurn */
    /****************************************************************************
   	* 
   	* Method: void testPrepareNextTurn
   	*  ****/
   	
       @Test(timeout = DEFAULT_TIMEOUT)
       public void testPrepareNextTurn() {
           Player actual_player = new Player("Player");
           actual_player.prepareNextTurn();
           int expected_bet = 0;
            
           assertEquals("Method testPrepareNextTurn was unsuccessfull", expected_bet,actual_player.getBet().getTotalValue()); 

       }
       
      /* End Method: testPrepareNextTurn */
      /****************************************************************************
      * 
      * Method: void testPrepareNextTurn
      *  ****/
      /*
      @Test(timeout = DEFAULT_TIMEOUT)
      public void testBetToken() {
           Player actual_player = new Player("Player");
           Tokens actual_token = new Tokens("Red",3);
           actual_player.betToken(actual_token);
           int expected_total_money = 440;
              
           assertEquals("Method testPrepareNextTurn was unsuccessfull", expected_total_money,actual_player.getTotalMoney()); 
       }
        */ 
       /* End Method: testPrepareNextTurn */ 
     /****************************************************************************
     * 
     * Method: void testToggleIsBetting
     *  ****/
      	
        @Test(timeout = DEFAULT_TIMEOUT)
        public void testToggleIsBetting() {
            Player actual_player = new Player("Player");
            actual_player.toggleIsBetting();
               
            assertTrue("Method testToggleIsBetting was unsuccessfull", actual_player.isBetting()); 

        }
          
      /* End Method: testToggleIsBetting */  
      /****************************************************************************
       * 
       * Method: void testToggleIsBetting
       *  ****/
          	
        @Test(timeout = DEFAULT_TIMEOUT)
        public void testIsBetting() {
            Player actual_player = new Player("Player");
                   
            assertFalse("Method testIsBetting was unsuccessfull", actual_player.isBetting()); 

        }
              
       /* End Method: testToggleIsBetting */
       /****************************************************************************
        * 
        * Method: void testToggleIsBetting
        *  ****/
           	
        @Test(timeout = DEFAULT_TIMEOUT)
        public void testSplit() {
            Player actual_player = new Player("Player");
            Hand actual_hand = new Hand();
            Suit suit_1 = new Suit("Clubs");
            Suit suit_2 = new Suit("Diamonds");
            Card first_card = new Card (10,"Ten",suit_1);
            Card second_card = new Card (10,"Ten",suit_2);
            
            actual_player.Split(first_card, second_card, actual_hand);
            
            assertFalse("Method testIsBetting was unsuccessfull", actual_player.isBetting()); 

        } 
                
       /* End Method: testToggleIsBetting */
        
        

}