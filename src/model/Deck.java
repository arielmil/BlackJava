/***********************************************************************/

package model;

/***********************************************************************/

class Deck {
	private int quantity;
	private static Stack deck;
	private static Stack bin;
	
	/***************************************************************************
	*  Method: Constructor - Deck : Initializes the Deck
	*  ****/
	
	Deck() {
		
		deck = new Stack();
		bin = new Stack();
		Suit suits[] = new Suit[4];
		
		int i, j;
		Card card;
		
		String card_names[] = new String[] {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		int card_values[] = new int[] {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10 , 10};
		String card_suits_names[] = new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};
		
		for (i = 0; i < 4; i++) {
			suits[i] = new Suit(card_suits_names[i]);
		}
		
		/*Create a single complete Deck */
		for (i = 0; i < 13; i++) {
			for (j = 0; j < 4; j++) {
				card = new Card(card_values[i], card_names[i], suits[j]);
				deck.insertL(card);
			}
		}
		
		/*Add three copies of that deck to the deck stack*/
		deck.copyNTimes(3);
		
		quantity = deck.getSize();
	}
	/* End Method: Constructor - Deck */
	/*
	***************************************************************************
	*  Method: void shuffle : Shuffles the Cards in the Deck
	*  ****/
	
	void shuffle() {
		deck.shuffle();
	}
	/* End Method: void shuffle */
	/*
	***************************************************************************
	*  Method: Card draw : Draw a Card from the Deck
	*  ****/
	
	Card draw() {
		deckSubtract();
		return (Card) deck.drawL();
	}
	/* End Method: Card draw */
	/*
	***************************************************************************
	*  Method: void deckSubtract : Subtracts a Card unit in the quantity variable
	*  ****/
	
	void deckSubtract() {
		quantity--;
	}
	/* End Method: void deckSubtract */
	/*
	***************************************************************************
	*  Method: int getQuantity : Returns how many Cards are currently in the Deck
	*  ****/
	
	int getQuantity() {
		return quantity;
	}
	/* End Method: int getQuantity */
	/*
	****************************************************************************
	 * 
	 * To be implemented...
	 * 
	 * Method: void render: Render the image of the Deck on the Screen.
	 *  ****/
	/*void render() {
	
	
	}*/
	/* End Method: void render */
	
}