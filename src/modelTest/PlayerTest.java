package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;


public class PlayerTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	* 
	* Method: void testGetIsElevenChangesValue
	*  ****/
	
    @Test(timeout = DEFAULT_TIMEOUT)
    public void testaddTokens() {
        Player actual_player = new Player("Player");
        List actual_token_list = new List();
        Tokens actual_token_1 = new Tokens ("Red",2);
        Tokens actual_token_2 = new Tokens ("Blue",3);
        actual_token_list.insertL(actual_token_1);
        actual_token_list.insertL(actual_token_2);
        
        int expected_value = 70;
        
        actual_player.addTokens(actual_token_list);
          
        assertEquals("Method testaddTokens was unsuccessfull", expected_value,actual_player.getTotalMoney()); 

    }
    
    /* End Method: testIsInsuranceIsInitiallyFalse */

}