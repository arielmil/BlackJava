package model;

public class AbstractPlayer {
	private String name;
	private List hands;
	private boolean isPlaying;
	private boolean isBroke;
	
	public AbstractPlayer(String name) {
		this.name = name;
		hands = new List();
		
		Hand hand = new Hand();
		hands.insertL(hand);
		
		isPlaying = false;
	}
	
	public void takeCard(Card card, int whichHand) {
		if (isPlaying) {
			if(!isBroke) {
				Hand hand = (Hand)this.hands.get(whichHand);
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
	
	public List getHand() {
		return hands;
	}
	
}