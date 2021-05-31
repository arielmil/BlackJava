package modelTest;

import model.*;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DealerTest {
	
	private static final int DEFAULT_TIMEOUT = 5000;
	
	
	/****************************************************************************
	* 
	* Method: void testsetIsTenIsTrue: Tests the case if the boolean parameter is true
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testsetIsTenIsTrue() {
        Dealer actual = new Dealer ();
        
        actual.setIsTen(true);
        assertTrue("Method setIsTen for true was unsuccessfull",actual.FirstDrawIsTen);

    }

	/* End Method: testsetIsTenIsTrue */
	/*
	****************************************************************************
	* 
	* Method: void testsetIsTenIsFalse: Tests the case if the boolean parameter is false
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testsetIsTenIsFalse() {
        Dealer actual = new Dealer ();
               
        actual.setIsTen(false);
        assertFalse("Method setIsTen for false was unsuccessfull",actual.FirstDrawIsTen);

    }
	
	/* End Method: testsetIsTenIsFalse */

}
