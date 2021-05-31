package model;

public class Hand {
	public List cards;
	public int score;
	public boolean isBusted;
	private boolean isBlackJack;
	private boolean stopDraw;
	private boolean canSplit;
	private boolean stoppedThisTurn;
	
	public Hand() {
		cards = new List();
		setScoreToZero();
	}
	
	public void countScore(boolean isDrawPhase) {
		int i;
		
		Card card;
		for (i = 0; i < cards.getSize(); i++) {
			card = (Card)cards.get(i);
			score = score + card.getValue();
		}
		
		if (score > 21) {
			isBusted = true;
		}
		
		else if (score == 21 && isDrawPhase) {
			isBlackJack = true;
		}
		
	}
	
	public int getscore() {
		return score;
	}
	
	public boolean getIsBusted() {
		return isBusted;
	}
	
	public boolean getIsBlackJack() {
		return isBlackJack;
	}
	
	
	public void stopDraw() {
		stopDraw = true;
	}
	
	public boolean canDraw() {
		return stopDraw;
	}
		
	public boolean IsTwentyOne() {
		return score == 21;
	}
	
	public void setScoreToZero() {
		score = 0;
		isBusted = false;
		isBlackJack = false;
		stopDraw = false;
		canSplit = false;
		stoppedThisTurn = false;
	}
	
	public void addCard(Card card) {
		cards.insertL(card);
	}
	
	public boolean canSplit() {
		if (cards.getSize() == 2 && (cards.get(0).equals(cards.get(1)))) {
			canSplit = true;
		}
		
		return canSplit;
	}
	
	public void stop() {
		stoppedThisTurn = true;
	}
	
	public boolean isStopped() {
		return stoppedThisTurn;
	}
	
	public List clear() {
		setScoreToZero();
		return cards.drawAll();
	}
	
	/* void render() {
		
	} */
}
