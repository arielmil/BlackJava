
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
	
    /*
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testAddTokens() {
        
                
    }
    
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testAddTokens() {
        
                
    }
    
    @Test (timeout = DEFAULT_TIMEOUT)
    public void subtractTokens() {
        
                
    }
    
    @Test (timeout = DEFAULT_TIMEOUT)
    public void subtractTokensFromValue() {
        
                
    }
    */
    
    
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