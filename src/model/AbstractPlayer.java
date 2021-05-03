/***********************************************************************/

package model;

/***********************************************************************/

class AbstractPlayer {
	private String name;
	private List hands;
	private boolean isPlaying;
	
	/***************************************************************************
	*  Method: Constructor - PlayerWrapper : Initializes the PlayerWrapper
	*  ****/
	
	AbstractPlayer(String name) {
		this.name = name;
		hands = new List();
		
		Hand hand = new Hand();
		hands.insertL(hand);
		
		isPlaying = false;
	}
	/* End Method: Constructor - Player */
	/*
	***************************************************************************
	*  Method: String getName : Returns the Name of the Player (!)
	*  ****/
	
	void hit(Card card) {
		Hand hand = (Hand)this.hands.get(0);
		hand.addCard(card);
	}
	
	void stand() {
		endTurn();
	}
	
	String getName() {
		return name;
	}
	
	void playerTurn() {
		isPlaying = true;
	}
	
	boolean getIsPlaying() {
		return isPlaying;
	}
	
	void endTurn() {
		isPlaying = false;
	}
	
	List getHand() {
		return hands;
	}
	
}