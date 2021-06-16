<<<<<<< HEAD
// Ariel Mileguir
// Pedro Gabriel 


package model;

public class Ace extends Card {
	
	boolean isEleven = true;
	
	
	/* Method: Constructor - Ace : Initializes the Card - Ace*/
	
	public Ace(String name, Suit suit) {
		super(11, name, suit);
	}
	
	/* Method: boolean getIsEleven */
	
	public boolean getIsEleven() {
		return isEleven;
	}
	
	/* Method: void changeValue : Decide whether the ace can be 11 */
	
	public void changeValue() {
		isEleven = false;
		setValue(1);
	}
	 
=======
// Ariel Mileguir
// Pedro Gabriel 


package model;

public class Ace extends Card {
	
	boolean isEleven = true;
	
	
	/* Method: Constructor - Ace : Initializes the Card - Ace*/
	
	public Ace(String name, Suit suit) {
		super(11, name, suit);
	}
	
	/* Method: boolean getIsEleven */
	
	public boolean getIsEleven() {
		return isEleven;
	}
	
	/* Method: void changeValue : Decide whether the ace can be 11 */
	
	public void changeValue() {
		isEleven = false;
		setValue(1);
	}
	 
>>>>>>> c2c4341aba2c334e874c0d0abe1fb064931b276b
}