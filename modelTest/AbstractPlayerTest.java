package modelTest;

import model.*;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AbstractPlayerTest {

    @Test
    public void testGetName() {
        AbstractPlayer absplayer = new AbstractPlayer("playername");

        assertTrue(absplayer.getName() == "playername");

    }
}