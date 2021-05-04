package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class BetTest {

	
	
    @Test
    public void testGetTotalVallue() {
        Bet bet = new Bet();

        assertEquals(bet.totalValue,bet.getTotalValue());

    }
    
    @Test
    public void testGetTokens() {
        Bet bet = new Bet();
        
        assertEquals(bet.tokens,bet.getTokens());

    }
    
    

}