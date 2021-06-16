
// Ariel Mileguir
// Pedro Gabriel 

/***********************************************************************/

package model;

/***********************************************************************/

public class Card {
	
	public int value;
	private String name;
	private Suit suit;
	private boolean revealed = false;
	/*private img;*/
	

	/***************************************************************************
	*  Method: Constructor - Card : Initializes the Cards
	*  ****/
	
	public Card(int value, String name, Suit suit) {
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
	
	
	public int getValue() {
		return value;
	}
	/* End Method: int getValue */
	
	public void setValue(int value) {
		this.value = value;
	}
	
	/*
	****************************************************************************
	 * 
	 * Method: String getName : Returns a String with the Name of the Card
	 *  ****/
	
	public String getName() {
		return name;
	}
	
	/* End Method: int getValue */
	/*
	****************************************************************************
	 * 
	 * Method: void reveal : Reveal the Card
	 *  ****/
	
	public void toggleReveal() {
		revealed = !revealed;
	}
	/* End Method: void reveal */
	/*
	****************************************************************************
	 * 
	 * Method: boolean getRevealed : Returns the status of the Card: If it's hidden or showing
	 *  ****/
	
	/*
	 ****************************************************************************
	 * 
	 * Method: Suit getSuit: Returns the Suit of the Card
	 *  ****/
	public Suit getSuit() {
		return suit;
	}
	
	/* End Method: Suit getSuit */
	/*
	****************************************************************************
	 * 
	 * Method: String getSuitname: Returns the Name of the Card Suit
	 *  ****/
	
	public String getSuitname() {
		return suit.getName();
	}
	
	public boolean getRevealed() {
		return revealed;
	}
	/* End Method: boolean getRevealed */
	
	public boolean equals(Card card) {
		if (name == card.name) {
			return true;
		}
		
		return false;
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