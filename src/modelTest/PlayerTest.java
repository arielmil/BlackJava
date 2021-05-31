package modelTest;

import model.*;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PlayerTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	* 
	* Method: void testGetIsElevenChangesValue
	*  ****/
	
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testIsInsuranceIsInitiallyFalse() {
        Player player = new Player("Player");
        assertFalse("Testing whether insurance was initialized at false value", player.getInsurance()); 

    }
    
    /* End Method: testIsInsuranceIsInitiallyFalse */

}