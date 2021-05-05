package modelTest;

import model.*;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PlayerTest {

    @Test
    public void testIsInsuranceIsInitiallyFalse() {
        Player player = new Player("Player");
        assertFalse("Testing whether insurance was initialized at false value", player.getInsurance()); 

    }
}