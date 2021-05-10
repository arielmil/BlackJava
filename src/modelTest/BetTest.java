
package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class BetTest {

	
	private static final int DEFAULT_TIMEOUT = 5000;
	
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testGetTotalVallue() {
        Bet bet = new Bet();

        assertEquals("Method getTotalValue didn't worked successfully",bet.totalValue,bet.getTotalValue());

    }
    
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testGetTokens() {
        Bet bet = new Bet();
        
        assertEquals("Method getTokens didn't worked successfully",bet.tokens,bet.getTokens());

    }
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
    
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testclear() {
        Bet actual = new Bet();
        int expected = 0;
        actual.clear();
        
        assertEquals("Method getTokens didn't worked successfully",expected,actual.totalValue);

    }

}