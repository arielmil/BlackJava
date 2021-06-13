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
    	* Method: void testgetColor
    	*  ****/
    	/*
        @Test (timeout = DEFAULT_TIMEOUT)
        public void testgetTotal() {
            Tokens actual_tokens = new Tokens("Red", 10);
            actual_tokens.tokensAdd(actual_tokens);
            
                     
            assertEquals("Method testgetTotal didn't worked sucessfully",actual.color,actual.getCol));
        }*/
        
        /* End Method: testGetQuantity */

}
