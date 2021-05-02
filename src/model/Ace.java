package model;

class Ace extends Card {
	
	boolean isEleven = true;
	
	
	/* Method: Constructor - Ace : Initializes the Card - Ace*/
	Ace(String name, Suit suit) {
		super(11, name, suit);
	}
	
	/* Method: boolean getIsEleven */
	
	boolean getIsEleven() {
		return isEleven;
	}
	
	/* Method: void changeValue : Decide whether the ace can be 11 */
	void changeValue() {
		isEleven = false;
		setValue(1);
	}
	 
	/* To be implemented...
	 
	  Method: void render: Render the image of the Ace Card on the Screen. */
	/*	void render() {
		
	}
	
	/* End Method: void render */
}