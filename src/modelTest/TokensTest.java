// Ariel Mileguir
// Pedro Gabriel 

package modelTest;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Tokens;

public class TokensTest {
	
	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	* 
	* Method: void testGetValue
	*  ****/
	
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testgetValue() {
        Tokens actual = new Tokens("Red", 10);
        int expected_value = 100;
        actual.value = expected_value;
        

        assertEquals("Method getValue didn't work sucessfully",expected_value,actual.getValue());
    }
    
    /* End Method: testGetValue */
    /****************************************************************************
	* 
	* Method: void testGetValue
	*  ****/
	
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testgetQuantity() {
        Tokens actual = new Tokens("Red", 10);
        int expected_quantity = 100;
        actual.quantity = expected_quantity;
        

        assertEquals("Method testgetQuantity didn't worked sucessfully",expected_quantity,actual.getQuantity());
    }
    
    /* End Method: testGetQuantity */
    /****************************************************************************
  	* 
  	* Method: void testgetColor
  	*  ****/
  	
      @Test (timeout = DEFAULT_TIMEOUT)
      public void testgetColor() {
          Tokens actual = new Tokens("Red", 10);
                   
          assertEquals("Method testgetQuantity didn't worked sucessfully",actual.color,actual.getColor());
      }
      
      /* End Method: testGetQuantity */
      /****************************************************************************
    	* 
<<<<<<< HEAD
    	* Method: void testTokensAddMultipleTokens - testTokensAdd
=======
    	* Method: void testTokensAddMultipleTokens
>>>>>>> c2c4341aba2c334e874c0d0abe1fb064931b276b
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testTokensAddMultipleTokens() {
        	Tokens actual_token_1 = new Tokens("Red",3);
            Tokens actual_token_2 = new Tokens("Red", 4);
            actual_token_1.tokensAdd(actual_token_2);
            int expected_quantity = 7;
            int expected_total = 140;
            
            assertEquals("Method tokensAdd didn't worked successfully",expected_quantity,actual_token_1.getQuantity());
            assertEquals("Method tokensAdd didn't worked successfully",expected_total,actual_token_1.getTotal());
                     
        }
        
        /* End Method: testTokensAddWithParameters */
        /****************************************************************************
    	* 
<<<<<<< HEAD
    	* Method: void testTokensAddOnlyOne - testTokensAdd
=======
    	* Method: void testTokensAddOnlyOne
>>>>>>> c2c4341aba2c334e874c0d0abe1fb064931b276b
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testTokensAddOnlyOne() {
        	Tokens actual_token = new Tokens("Red",3);
        	actual_token.tokensAdd();
        	int expected_quantity = 4;
        	int expected_total = 80;
            
            assertEquals("Method tokensAddOnlyOne didn't worked successfully because of Quantity",expected_quantity,actual_token.getQuantity());
            assertEquals("Method tokensAddOnlyOne didn't worked successfully because of Total",expected_total,actual_token.getTotal());
                     
        }
        
        /* End Method: testTokensAddOnlyOne */
        /****************************************************************************
    	* 
    	* Method: void testSetTotal
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testSetTotal() {
        	Tokens actual_token = new Tokens("Red",3);
        	actual_token.setTotal();
        	int expected_total = 60;
            
            assertEquals("Method tokensAdd didn't worked successfully",expected_total,actual_token.getTotal());
                     
        }
        
        /* End Method: testSetTotal */
        /****************************************************************************
    	* 
<<<<<<< HEAD
    	* Method: void testSubtractMultipleTokens - testTokensSubtract
=======
    	* Method: void testSubtractMultipleTokens
>>>>>>> c2c4341aba2c334e874c0d0abe1fb064931b276b
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testSubtractMultipleTokens() {
        	Tokens actual_token = new Tokens("Red",3);
        	int quantity = 2;
        	actual_token = actual_token.tokensSubtract(quantity);
        	int expected_quantity = 1;
            
            assertEquals("Method testSubtractMultipleTokens didn't worked successfully",expected_quantity,actual_token.getQuantity());
                     
        }
        
        /* End Method: testSubtractMultipleTokens */
        /****************************************************************************
    	* 
<<<<<<< HEAD
    	* Method: void testTokenSubtractOnlyOneToken - testTokensSubtract
=======
    	* Method: void testTokenSubtractOnlyOneToken
>>>>>>> c2c4341aba2c334e874c0d0abe1fb064931b276b
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testSubtractOnlyOneToken() {
        	Tokens actual_token = new Tokens("Red",3);
        	actual_token.tokenSubtract();
        	int expected_quantity = 2;
        	int expected_total = 40;
            
            assertEquals("Method testSubtract didn't worked successfully",expected_quantity,actual_token.getQuantity());
            assertEquals("Method testSubtract didn't worked successfully",expected_total,actual_token.getTotal());
                     
        }
        
        /* End Method: testSubtractOnlyOneToken */
        /****************************************************************************
    	* 
    	* Method: void testColorToValueGray
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testColorToValueGray() {
        	Tokens gray_token = new Tokens("Gray",1);
        	
        	int actual_gray_value;
        	actual_gray_value = gray_token.colorToValue(gray_token.getColor());
        	
        	int expected_gray_value = 1;
            
           assertEquals("Method testColorToValueGray didn't worked successfully",expected_gray_value,actual_gray_value);
                     
        }
        
        /* End Method: testColorToValueGray */
        /****************************************************************************
    	* 
    	* Method: void testColorToValuePurple
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testColorToValuePurple() {
        	Tokens purple_token = new Tokens("Purple",1);
        	
        	int actual_purple_value;
        	actual_purple_value = purple_token.colorToValue(purple_token.getColor());
        	
        	int expected_purple_value = 5;
            
           assertEquals("Method testColorToValuePurple didn't worked successfully",expected_purple_value,actual_purple_value);
                     
        }
        
        /* End Method: testColorToValuePurple */
        /****************************************************************************
    	* 
    	* Method: void testColorToValueBlue
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testColorToValueBlue() {
        	Tokens blue_token = new Tokens("Blue",1);
        	
        	int actual_blue_value;
        	actual_blue_value = blue_token.colorToValue(blue_token.getColor());
        	
        	int expected_blue_value = 10;
            
           assertEquals("Method testColorToValueBlue didn't worked successfully",expected_blue_value,actual_blue_value);
                     
        }
        
        /* End Method: testColorToValueBlue */
        /****************************************************************************
    	* 
    	* Method: void testColorToValueRed
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testColorToValueRed() {
        	Tokens red_token = new Tokens("Red",1);
        	
        	int actual_red_value;
        	actual_red_value = red_token.colorToValue(red_token.getColor());
        	
        	int expected_red_value = 20;
            
           assertEquals("Method testColorToValueRed didn't worked successfully",expected_red_value,actual_red_value);
                     
        }
        
        /* End Method: testColorToValueRed */
        /****************************************************************************
    	* 
    	* Method: void testColorToValueGreen
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testColorToValueGreen() {
        	Tokens green_token = new Tokens("Green",1);
        	
        	int actual_green_value;
        	actual_green_value = green_token.colorToValue(green_token.getColor());
        	
        	int expected_green_value = 50;
            
           assertEquals("Method testColorToValueGreen didn't worked successfully",expected_green_value,actual_green_value);
                     
        }
        
        /* End Method: testColorToValueGreen */
        /****************************************************************************
    	* 
    	* Method: void testColorToValueBlack
    	*  ****/
    	
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testColorToValueBlack() {
        	Tokens black_token = new Tokens("Black",1);
        	
        	int actual_black_value;
        	actual_black_value = black_token.colorToValue(black_token.getColor());
        	
        	int expected_black_value = 100;
            
           assertEquals("Method testColorToValueBlack didn't worked successfully",expected_black_value,actual_black_value);
                     
        }
        
        /* End Method: testColorToValueBlack */
        /****************************************************************************/
}

