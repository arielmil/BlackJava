package modelTest;

import model.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AceTest {

    @Test
    public void testGetIsElevenIsInitiallyTrue() {
        Ace ace = new Ace("Ás", new Suit("copas"));

        assertTrue(ace.getIsEleven());

    }

    @Test
    public void testGetIsElevenChangesValue() {
        Ace ace = new Ace("Ás", new Suit("copas"));

        assertTrue(ace.getIsEleven());
        ace.changeValue();
        assertFalse(ace.getIsEleven());
    }
}