package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Tokens;

public class TokensTest {
	
	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	* 
	* Method: void testGetValue
	*  ****/
	
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testgetValue() {
        Tokens actual = new Tokens("Red", 10);
        int expected_value = 100;
        actual.value = expected_value;
        

        assertEquals("Instance Boolean Variable IsEleven didn't initialized sucessfully",expected_value,actual.getValue());
    }
    
    /* End Method: testGetValue */
    /****************************************************************************
	* 
	* Method: void testGetValue
	*  ****/
	
    @Test (timeout = DEFAULT_TIMEOUT)
    public void testgetQuantity() {
        Tokens actual = new Tokens("Red", 10);
        int expected_quantity = 100;
        actual.quantity = expected_quantity;
        

        assertEquals("Instance Boolean Variable IsEleven didn't initialized sucessfully",expected_quantity,actual.getQuantity());
    }
    
    /* End Method: testGetValue */

}
