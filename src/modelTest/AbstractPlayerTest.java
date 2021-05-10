package modelTest;

import model.*;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AbstractPlayerTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testGetName() {
        AbstractPlayer actual = new AbstractPlayer("playername");
        
        
        assertTrue("Method getName was unsuccessfull",actual.getName() == "playername");

    }
}