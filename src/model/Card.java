/***********************************************************************/

package model;

/***********************************************************************/

class Card {
	
	private int value;
	private String name;
	private Suit suit;
	private boolean revealed = false;
	/*private img;*/
	

	/***************************************************************************
	*  Method: Constructor - Card : Initializes the Cards
	*  ****/
	
	Card(int value, String name, Suit suit) {
		setValue(value);
		
		this.name = name;
		this.suit = suit;
	}
	/* End Method: Constructor - Card */
	/*
	****************************************************************************
	 * 
	 * Method: int getValue : Returns an int with the value of the Card
	 *  ****/
	
	void setValue(int value) {
		this.value = value;
	}
	
	int getValue() {
		return value;
	}
	/* End Method: int getValue */
	/*
	****************************************************************************
	 * 
	 * Method: String getName : Returns a String with the Name of the Card
	 *  ****/
	
	String getName() {
		return name;
	}
	
	/* End Method: int getValue */
	/*
	****************************************************************************
	 * 
	 * Method: void reveal : Reveal the Card
	 *  ****/
	
	void reveal() {
		revealed = true;
	}
	/* End Method: void reveal */
	/*
	****************************************************************************
	 * 
	 * Method: boolean getRevealed : Returns the status of the Card: If it's hidden or showing
	 *  ****/
	
	boolean getRevealed() {
		return revealed;
	}
	/* End Method: boolean getRevealed */
	/*
	****************************************************************************
	 * 
	 * Method: Suit getSuit: Returns the Suit of the Card
	 *  ****/
	Suit getSuit() {
		return suit;
	}
	/* End Method: Suit getSuit */
	/*
	****************************************************************************
	 * 
	 * Method: String getSuitname: Returns the Name of the Card Suit
	 *  ****/
	
	String getSuitname() {
		return suit.getName();
	}
	
	int equals(Card card) {
		if (name == card.name) {
			return 1;
		}
		
		return 0;
	}
	/* End Method: String getSuitname */
	/*
	****************************************************************************
	 * 
	 * To be implemented...
	 * 
	 * Method: void render: Render the image of the Card on the Screen.
	 *  ****/
	/*void render() {
		
		
	}*/
	/* End Method: String getSuitname */
}