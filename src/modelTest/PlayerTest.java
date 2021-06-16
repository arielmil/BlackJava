// Ariel Mileguir
// Pedro Gabriel 

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
	* Method: void testaddTokens
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
<<<<<<< HEAD
=======

>>>>>>> c2c4341aba2c334e874c0d0abe1fb064931b276b
    }*/
    
    /* End Method: testaddTokens */
	/****************************************************************************
	* 
	* Method: void testInsurance
	*  ****/
	
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testInsurance() {
        Player actual_player = new Player("Player");
        
        actual_player.insurance();
        
        assertTrue("Method testgetInsurance was unsuccessfull", actual_player.getInsurance()); 

    }
    
    /* End Method: testGetInsurance */
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
        /*   	
        @Test(timeout = DEFAULT_TIMEOUT)
        public void testSplit() {
            Player actual_player = new Player("Player");
            Hand actual_hand = new Hand();
            Suit suit_1 = new Suit("Clubs");
            Suit suit_2 = new Suit("Diamonds");
            Card first_card = new Card (10,"Ten",suit_1);
            Card second_card = new Card (10,"Ten",suit_2);
            
            actual_player.Split(first_card, second_card);
            
            assertFalse("Method testIsBetting was unsuccessfull", actual_player.isBetting()); 
<<<<<<< HEAD
=======

>>>>>>> c2c4341aba2c334e874c0d0abe1fb064931b276b
        } */
                
       /* End Method: testToggleIsBetting */
        /****************************************************************************
         * 
         * Method: void testhit
         *  ****/
         /*   	
          @Test(timeout = DEFAULT_TIMEOUT)
          public void testHit() {
              Player actual_player = new Player("Player");
              
              Hand actual_hand = new Hand();
              Suit actual_suit = new Suit("Clubs");
              Card expected_card = new Card (10,"Ten",actual_suit);
              actual_player.hit(expected_card, actual_hand);
              
              List expected_hand = actual_player.getHands();
              
              assertEquals("Method testHit was unsuccessfull", expected_card.getName(),actual_card.getName()); 
<<<<<<< HEAD
=======

>>>>>>> c2c4341aba2c334e874c0d0abe1fb064931b276b
          }*/
                
         /* End Method: testToggleIsBetting */
        /****************************************************************************
         * 
         * Method: void testcanDouble
         *  ****/
            	
          @Test(timeout = DEFAULT_TIMEOUT)
          public void testcanDouble() {
              Player actual_player = new Player("Player");
              
              assertTrue("Method testcanDouble was unsuccessfull", actual_player.canDouble()); 

          }
                
         /* End Method: testcanDouble */ 
         /****************************************************************************
         * 
         * Method: void testgetTotalMoney
         *  ****/
            	
          @Test(timeout = DEFAULT_TIMEOUT)
          public void testgetTotalMoney() {
              Player actual_player = new Player("Player");
              int expected_total_money = 500;
               
              assertEquals("Method testgetTotalMoney was unsuccessfull", expected_total_money,actual_player.getTotalMoney()); 

          }
                  
         /* End Method: testgetTotalMoney */ 
          /****************************************************************************
           * 
           * Method: void testinitializedTokenslist
           *  ****/
              	
            @Test(timeout = DEFAULT_TIMEOUT)
            public void testInitializeTokensList() {
                Player actual_player = new Player("Player");
               
                actual_player.initializeTokensList();
                
                

            }
                    
           /* End Method: testgetTotalMoney */ 
       
        
        

}