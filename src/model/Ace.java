package model;

class Ace extends Card {
	
	Ace(String name, Suit suit) {
		super(11, name, suit);
	}
	
	boolean isEleven = true;
	
	boolean getIsEleven() {
		return isEleven;
	}
	
	void changeValue() {
		isEleven = false;
	}
	
	/*void render() {
		
	}*/
}
