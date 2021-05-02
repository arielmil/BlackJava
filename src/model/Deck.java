package model;

class Deck {
	private int quantity;
	private static Stack deck;
	private static Stack bin;
	
	Deck() {
		deck = new Stack();
		bin = new Stack();
		Suit suits[] = new Suit[4];
		
		int i, j, w;
		Card card;
		
		String card_names[] = new String[] {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		int card_values[] = new int[] {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10 , 10};
		String card_suits_names[] = new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};
		
		for (i = 0; i < 4; i++) {
			suits[i] = new Suit(card_suits_names[i]);
		}
		
		/*Create a single complete Deck */
		for (i = 0; i < 52; i++) {
			for (j = 0; j < 13; j++) {
				for (w = 0; w < 4; w++) {
					card = new Card(card_values[j], card_names[j], suits[w]);
					deck.insertL(card);
				}
			}
		}
		
		/*Add three copies of that deck to the deck stack*/
		deck.copyNTimes(3);
		
		quantity = deck.getSize();
	}
	
	void shuffle() {
		deck.shuffle();
	}
	
	Card draw() {
		deckSubtract();
		return (Card) deck.drawL();
	}
	
	void deckSubtract() {
		quantity--;
	}
	
	int getQuantity() {
		return quantity;
	}
	
	/*void render();*/
	
}
