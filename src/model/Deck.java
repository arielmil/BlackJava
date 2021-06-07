package model;

public class Deck {
	private int quantity;
	private List deck;
	private List bin;
	
	private String cardNames[];
	private String cardSuitsNames[];
	private int cardValues[];
	
	public Deck() {
		
		deck = new List();
		bin = new List();
		
		cardNames = new String[] {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		cardSuitsNames = new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};
		cardValues = new int[] {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10 , 10};
		
		makeOneDeck();
		
		deck.copyNTimes(3);
		
		quantity = deck.getSize();
	}
		
	public void shuffle() {
		deck.shuffle();
	}
	
	public Card draw() {
		deckSubtract();
		return (Card) deck.drawL();
	}
		
	public void deckSubtract() {
		quantity--;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void makeOneDeck() {
		int i, j;
		Card card;
		Suit suits[] = new Suit[4];
		
		for (i = 0; i < 4; i++) {
			suits[i] = new Suit(cardSuitsNames[i]);
		}
		
		/*Create a single complete Deck */
		for (i = 0; i < 13; i++) {
			for (j = 0; j < 4; j++) {
				card = new Card(cardValues[i], cardNames[i], suits[j]);
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
	 
	public String[] getCardNames() {
		return cardNames;
	}
	
	public String[] getCardSuitNames() {
		return cardSuitsNames;
	}
	
	public int[] getCardValues() {
		return cardValues;
	}
	
}