package modelTest;

import model.*;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DealerTest {
	
	private static final int DEFAULT_TIMEOUT = 5000;
	
	/*
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetTotalVallue() {
        Dealer actual = new Dealer ();
        


    }*/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testsetIsTen() {
        Dealer actual = new Dealer ();
        
        actual.setIsTen(true);
        assertTrue("Method getName was unsuccessfull",actual.FirstDrawIsTen);
        
        actual.setIsTen(false);
        assertFalse("Method getName was unsuccessfull",actual.FirstDrawIsTen);

        


    }

}
