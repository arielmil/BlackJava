package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import model.Suit;

public class SuitTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	
	/****************************************************************************
	* 
	* Method: void testGetNameReturnsExpectedName
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testGetNameReturnsExpectedName() {
        Suit actual = new Suit("Clubs");
        String expected = "Clubs";

        assertEquals("Method getName didn't worked successfully",expected, actual.getName());
    }
	
	/* End Method: testGetNameReturnsExpectedName */
	
}
