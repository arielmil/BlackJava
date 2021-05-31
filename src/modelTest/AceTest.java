package modelTest;

import model.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AceTest {
	
	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	* 
	* Method: void testGetIsElevenIsInitiallyTrue
	*  ****/
	
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testGetIsElevenIsInitiallyTrue() {
        Ace actual = new Ace("Ás", new Suit("copas"));

        assertTrue("Instance Boolean Variable IsEleven didn't initialized sucessfully",actual.getIsEleven());

    }
    
    /* End Method: testGetIsElevenIsInitiallyTrue */
	/*
	****************************************************************************
	* 
	* Method: void testGetIsElevenChangesValue
	*  ****/

    @Test (timeout = DEFAULT_TIMEOUT)
    public void testGetIsElevenChangesValue() {
        Ace actual = new Ace("Ás", new Suit("copas"));

        actual.changeValue();
        assertFalse("Method getIsEleven didn't worked successfully",actual.getIsEleven());
    }
    
    /* End Method: testGetIsElevenChangesValue */
	/*
	****************************************************************************/
}