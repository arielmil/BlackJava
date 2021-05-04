/***********************************************************************/

package model;

/***********************************************************************/

class Deck {
	private int quantity;
	private static List deck;
	private static List bin;
	
	/***************************************************************************
	*  Method: Constructor - Deck : Initializes the Deck
	*  ****/
	
	public Deck() {
		
		deck = new List();
		bin = new List();
		
		makeOneDeck();
		
		/*Add three copies of that deck to the deck stack*/
		deck.copyNTimes(3);
		
		quantity = deck.getSize();
	}
	/* End Method: Constructor - Deck */
	/*
	***************************************************************************
	*  Method: void shuffle : Shuffles the Cards in the Deck
	*  ****/
	
	public void shuffle() {
		deck.shuffle();
	}
	/* End Method: void shuffle */
	/*
	***************************************************************************
	*  Method: Card draw : Draw a Card from the Deck
	*  ****/
	
	public Card draw() {
		deckSubtract();
		return (Card) deck.drawL();
	}
	/* End Method: Card draw */
	/*
	***************************************************************************
	*  Method: void deckSubtract : Subtracts a Card unit in the quantity variable
	*  ****/
	
	public void deckSubtract() {
		quantity--;
	}
	/* End Method: void deckSubtract */
	/*
	***************************************************************************
	*  Method: int getQuantity : Returns how many Cards are currently in the Deck
	*  ****/
	
	public int getQuantity() {
		return quantity;
	}
	
	public void makeOneDeck() {
		int i, j;
		Card card;
		Suit suits[] = new Suit[4];
		
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
	}
	
	
	public void addToBin(Card card) {
		bin.insertL(card);
	}
	
	/* ArrayList.addAll(Collection) could be used, but since it was choosen to abstract the use of such structure for the use of List (which contains an private ArrayList)
	 * we decided to simulate the use of ArrayList.addAll (and after that, the use of ArrayList.clear() 
	 */
	
	public void emptyBin() {
		deck.moveFrom(bin);
	}
	 
	/*void render() {
	
	
	}*/
	/* End Method: void render */
	
}