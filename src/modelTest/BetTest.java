
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
    /*
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testGetTokens() {
        Bet bet = new Bet();
        
        assertEquals("Method getTokens didn't worked successfully",bet.tokens,bet.getTokens());

    }
    
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testAddTokens(String color) {
        
                
    }
    
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testAddTokens(String color, int i) {
        
                
    }
    
    @Test (timeout = DEFAULT_TIMEOUT)
    public void subtractTokens(String color) {
        
                
    }*/

}