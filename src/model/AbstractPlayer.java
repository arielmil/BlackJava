package model;

public class AbstractPlayer {
	private String name;
	public List hands;
	public boolean isPlaying;
	public boolean isTurnWinner;
	
	public AbstractPlayer(String name) {
		this.name = name;
		hands = new List();
		
		Hand hand = new Hand();
		hands.insertL(hand);
		
		isPlaying = false;
	}
	
	public boolean isBroke(Hand hand) {
		hand = (Hand)hands.acess(hand);
		return hand.getIsBusted();
	}
	
	public void takeCard(Card card, Hand hand) {
		if (isPlaying) {
			if(!isBroke(hand)) {
				hand = (Hand)this.hands.acess(hand);
				hand.addCard(card);				
			}
			
			/*execao de estar quebrado*/
			return;
		}
		
		/*execao de nao estar jogando*/
		return;
	}
	
	public void stand() {
		endTurn();
	}
	
	public String getName() {
		return name;
	}
	
	public void playerTurn() {
		isPlaying = true;
	}
	
	public boolean getIsPlaying() {
		return isPlaying;
	}
	
	public void endTurn() {
		isPlaying = false;
	}
	
	public List getHands() {
		return hands;
	}
	
	public List prepareNextTurn() {
		List cards = new List();
		
		int i;
		for (i = 0; i < hands.getSize(); i++) {
			Hand hand = (Hand)hands.get(i);
			cards.moveFrom(hand.clear());
		}
		
		return cards;
	}
	
	public void turnWinner() {
		isTurnWinner = true;
	}
	
	public boolean isTurnWinner() {
		return isTurnWinner;
	}
}