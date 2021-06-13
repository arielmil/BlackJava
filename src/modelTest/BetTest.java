
package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class BetTest {

	
	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	* 
	* Method: void testGetTotalValue
	*  ****/
	
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testGetTotalValue() {
        Bet bet = new Bet();

        assertEquals("Method getTotalValue didn't worked successfully",bet.totalValue,bet.getTotalValue());

    }
    
    /* End Method: testGetTotalValue */
	/*
	****************************************************************************
	* 
	* Method: void testGetTokens
	*  ****/
    
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testGetTokens() {
        Bet bet = new Bet();
        
        assertEquals("Method getTokens didn't worked successfully",bet.tokens,bet.getTokens());

    }
    
    /* End Method: testGetTokens */
    /****************************************************************************
	* 
	* Method: void testaddTokensRed
	*  ****/
	
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testaddTokensGray() {
        Bet actual_bet = new Bet();
        actual_bet.addTokens("Gray");
       int expected_total_value = 1;
        
        assertEquals("Method addTokensGray didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

    }
    /* End Method: testaddTokensRed */
    /****************************************************************************
  	* 
  	* Method: void testaddTokensGray
  	*  ****/
  	
      @Test (timeout = DEFAULT_TIMEOUT)
      public void testaddTokensPurple() {
          Bet actual_bet = new Bet();
          actual_bet.addTokens("Purple");
          int expected_total_value = 5;
         
          assertEquals("Method addTokensGray didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

      }
      /* End Method: testaddTokensGray */
      /****************************************************************************
    	* 
    	* Method: void testaddTokensBlue
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testaddTokensBlue() {
            Bet actual_bet = new Bet();
            actual_bet.addTokens("Blue");
            int expected_total_value = 10;
           
            assertEquals("Method addTokensBlue didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

        }
        /* End Method: testaddTokensBlue */
        /****************************************************************************
    	* 
    	* Method: void testaddTokensRed
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testaddTokensRed() {
            Bet actual_bet = new Bet();
            actual_bet.addTokens("Red");
            int expected_total_value = 20;
           
            assertEquals("Method addTokensRed didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

        }
        /* End Method: testaddTokensRed */
        /****************************************************************************
    	* 
    	* Method: void testaddTokensRed
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testaddTokensGreen() {
            Bet actual_bet = new Bet();
            actual_bet.addTokens("Green");
            int expected_total_value = 50;
           
            assertEquals("Method addTokensGreen didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

        }
        /* End Method: testaddTokensGreen */
        /****************************************************************************
    	* 
    	* Method: void testaddTokensRed
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testaddTokensBlack() {
            Bet actual_bet = new Bet();
            actual_bet.addTokens("Black");
            int expected_total_value = 100;
           
            assertEquals("Method addTokensBlack didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

        }
        /* End Method: testaddTokensBlack */
        /****************************************************************************
    	* 
    	* Method: void testaddTokensTwoRed
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testaddTokensTwoRed() {
            Bet actual_bet = new Bet();
            actual_bet.addTokens("Red",2);
            int expected_total_value = 40;
           
            assertEquals("Method addTokensBlack didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

        }
        /* End Method: testaddTokensTwoRed */
        /****************************************************************************
    	* 
    	* Method: void testaddTokensTwoTimes
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testaddTokensTwoTimes() {
            Bet actual_bet = new Bet();
            actual_bet.addTokens("Red",2);
            actual_bet.addTokens("Blue",4);
            int expected_total_value = 80;
           
            assertEquals("Method addTokensTwoTimes didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

        }
        /* End Method: testaddTokensTwoTimes */
        /****************************************************************************
    	* 
    	* Method: void testsubtractOneToken
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testsubtractOneToken() {
            Bet actual_bet = new Bet();
            Tokens actual_tokens = new Tokens ("Red",1);
            actual_bet.addTokens("Red",2);
            actual_bet.subtractTokens(actual_tokens);
            
            int expected_total_value = 20;
           
            assertEquals("Method subtractOneToken didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

        }
        /* End Method: testsubtractOneToken */  
        /****************************************************************************
    	* 
    	* Method: void testsubtractThreeTokens
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testsubtractThreeTokens() {
            Bet actual_bet = new Bet();
            Tokens actual_tokens = new Tokens ("Blue",3);
            actual_bet.addTokens("Blue",5);
            actual_bet.subtractTokens(actual_tokens);
            
            int expected_total_value = 20;
           
            assertEquals("Method testsubtractThreeTokens didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

        }
        /* End Method: testsubtractThreeTokens */ 
        /****************************************************************************
    	* 
    	* Method: void testsubtractTokensFromValue
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testsubtractTokensFromValue() {
            Bet actual_bet = new Bet();
            int tokens_value = 50;
            actual_bet.addTokens("Red",2);
            actual_bet.addTokens("Blue",4);
            
            actual_bet.subtractTokensFromValue(tokens_value);
            
            int expected_total_value = 30;
           
            assertEquals("Method testsubtractThreeTokens didn't worked successfully",expected_total_value,actual_bet.getTotalValue());

        }
        /* End Method: testsubtractTokensFromValue */  
        /****************************************************************************
         * 
         * Method: void testclear
         *  ****/
    
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testclear() {
        	Bet actual = new Bet();
        	int expected = 0;
        	actual.clear();
        
        	assertEquals("Method getTokens didn't worked successfully",expected,actual.totalValue);

        }
        /* End Method: testclear */

}