package model;

class Card {
	
	private int value;
	private String name;
	private Suit suit;
	private boolean revealed = false;
	/*private img;*/
	
	Card(int value, String name, Suit suit) {
		this.value = value;
		this.name = name;
		this.suit = suit;
	}
	
	int getValue() {
		return value;
	}
	
	String getName() {
		return name;
	}
	
	void reveal() {
		revealed = true;
	}
	
	boolean getRevealed() {
		return revealed;
	}
	
	Suit getSuit() {
		return suit;
	}
	
	String getSuitname() {
		return suit.getName();
	}
	
	/*void render() {
		
	}*/
}
