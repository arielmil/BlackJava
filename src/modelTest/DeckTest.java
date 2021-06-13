package modelTest;

import model.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DeckTest {
	
	private static final int DEFAULT_TIMEOUT = 5000;

	/****************************************************************************
	* 
	* Method: void testdraw
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testdraw() {
        Deck actual_deck = new Deck();
        Card actual_card,expected_card;
        int actual_size_deck = actual_deck.getQuantity();
        actual_card = (Card)actual_deck.deck.get(actual_deck.quantity-1);
        expected_card=actual_deck.draw();
        int expected_size_deck = actual_deck.getQuantity();
        
        // Checking if the Size is correct
        assertEquals("Method testdraw was unsuccessfull because of Size",expected_size_deck+1,actual_size_deck);
        // Checking if the Card is correct
        assertEquals("Method testdraw was unsuccessfull because of Card Name",expected_card.getName(),actual_card.getName());
        assertEquals("Method draw was unsuccessfull because of Card Suit",expected_card.getSuit(),actual_card.getSuit());
        assertEquals("Method draw was unsuccessfull because of Card Value",expected_card.getValue(),actual_card.getValue()); 
        
    }
	/* End Method: testdraw */
	/****************************************************************************
	* 
	* Method: void testdeckSubtract
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testdeckSubtract() {
        Deck actual_deck = new Deck();
        int actual_quantity = actual_deck.getQuantity();
        actual_deck.deckSubtract();
        
        int expected_quantity = actual_deck.getQuantity() + 1;
        
        assertEquals("Method testdeckSubtract was unsuccessfull",expected_quantity,actual_quantity);
    }
	/* End Method: testdeckSubtract */
	/****************************************************************************
	* 
	* Method: void testgetQuantity
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetQuantity() {
        Deck actual_deck = new Deck();
        int actual_quantity = actual_deck.getQuantity();
        int expected_quantity = 208;
        
        assertEquals("Method testgetQuantity was unsuccessfull",expected_quantity,actual_quantity);
    }
	/* End Method: testgetQuantity */
	/****************************************************************************
	* 
	* Method: void testgetQuantityBin
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetQuantityBin() {
        Deck actual_deck = new Deck();
        int actual_quantity = actual_deck.getQuantityBin();
        int expected_quantity = 0;
        
        assertEquals("Method testgetQuantityBin was unsuccessfull",expected_quantity,actual_quantity);
    }
	/* End Method: testgetQuantity */
	/****************************************************************************
	* 
	* Method: void testmakeOneDeck
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testmakeOneDeck() {
        Deck actual_deck = new Deck();
        Card actual_card,expected_card;
        Suit suits[] = new Suit[4];
        int i,k=0;
        
        for(i = 0; i < 4; i++) {
        	suits[i] = new Suit(actual_deck.getCardSuitNames()[i]);
        	
        }
        
        for (i = 0; i < 13; i++) {
        	for(int j = 0; j < 4; j++,k++) {
        		actual_card = new Card(actual_deck.getCardValues()[i],actual_deck.getCardNames()[i],suits[j]);
        		expected_card = (Card)actual_deck.deck.get(k);
        		assertEquals("Method testmakeOneDeck was unsuccessfull because of Card Value",expected_card.getValue(),actual_card.getValue());
        	    assertEquals("Method testmakeOneDeck was unsuccessfull because of Card Name",expected_card.getName(),actual_card.getName());
        	    assertEquals("Method testmakeOneDeck was unsuccessfull because of Card Suit",expected_card.getSuitname(),actual_card.getSuitname()); 
        	        
        	}
        }
    }
	/* End Method: testmakeOneDeck */
	/****************************************************************************
	* 
	* Method: void addToBin
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testaddToBin() {
        Deck actual_deck = new Deck();
        Suit actual_suit = new Suit ("Clubs");
        Card actual_card = new Card(10,"Ten",actual_suit);
        actual_deck.addToBin(actual_card);
        int actual_quantity = actual_deck.getQuantityBin();
        int expected_quantity = 1;
        Card expected_card = (Card)actual_deck.bin.get(0);

        assertEquals("Method testaddToBin Card was unsuccessfull",expected_card,actual_card);
        assertEquals("Method testaddToBin Quantity was unsuccessfull",expected_quantity,actual_quantity);
   
	}
	/* End Method: testaddToBin */
	/****************************************************************************
	* 
	* Method: void emptyBin
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testemptyBin() {
        Deck actual_deck = new Deck();
        Suit actual_suit = new Suit ("Clubs");
        Card actual_card = new Card(10,"Ten",actual_suit);
        
        actual_deck.addToBin(actual_card);
        actual_deck.addToBin(actual_card);
        actual_deck.emptyBin();
        int actual_quantity = actual_deck.getQuantityBin();
        int expected_quantity = 0;
                            
        assertEquals("Method testemptyBin Quantity was unsuccessfull",expected_quantity,actual_quantity);
        
	}
	/* End Method: testemptyBin */
	/****************************************************************************
	* 
	* Method: String[] testgetCardNames
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetCardNames() {
        Deck actual_deck = new Deck();
       
        String[] actual_card_name = actual_deck.getCardNames();
        String[] expected_card_name = new String[] {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
       
        for (int i=0;i<13;i++) {
                              
        	assertEquals("Method testgetCardNames was unsuccessfull",expected_card_name[i],actual_card_name[i]);
        }
	}
	/* End Method: testgetCardNames */
	/****************************************************************************
	* 
	* Method: String[] testgetCardNames
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetCardSuitNames() {
        Deck actual_deck = new Deck();
       
        String[] actual_card_suit_name = actual_deck.getCardSuitNames();
        String[] expected_card_suit_name = new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};
       
        for (int i=0;i<4;i++) {
                            
        assertEquals("Method testgetCardSuitNames was unsuccessfull",expected_card_suit_name[i],actual_card_suit_name[i]);
        }
	}
	/* End Method: testgetCardSuitnames */
	/****************************************************************************
	* 
	* Method: String[] testgetCardNames
	*  ****/
	
	@Test (timeout = DEFAULT_TIMEOUT)
    public void testgetCardValues() {
        Deck actual_deck = new Deck();
       
        int[] actual_card_values = actual_deck.getCardValues();
        int[] expected_card_values = new int[] {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10 , 10};
       
        for (int i=0;i<13;i++) {
                            
        	assertEquals("Method testgetCardValues was unsuccessfull",expected_card_values[i],actual_card_values[i]);
        
        }
	}
	/* End Method: testgetCardValues */
}
