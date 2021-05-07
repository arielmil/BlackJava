package model;

class Hand {
	private List cards;
	private int CurrentScore;
	private boolean isBroke;
	private boolean isBlackJack;
	private boolean stopDraw;
	private boolean isTwentyOne;
	private boolean canSplit;
	private boolean stoppedThisTurn;
	
	public Hand() {
		cards = new List();
		setCurrentScoresToZero();
	}
	
	public void countScore() {
		int i;
		
		Card card;
		for (i = 0; i < cards.getSize(); i++) {
			card = (Card)cards.get(i);
			CurrentScore = CurrentScore + card.getValue();
		}
		
		if (CurrentScore > 21) {
			isBroke = true;
		}
		
	}
	
	public int getCurrentScore() {
		return CurrentScore;
	}
	
	public boolean getIsBroke() {
		return isBroke;
	}
	
	public void setIsBlackJack() {
		isBlackJack = true;
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
	
	public void twentyOnePoints() {
		isTwentyOne = true;
	}
	
	public boolean getIsTwentyOne() {
		return isTwentyOne;
	}
	
	public void setCurrentScoresToZero() {
		CurrentScore = 0;
		isBroke = false;
		isBlackJack = false;
		stopDraw = false;
		isTwentyOne = false;
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
		setCurrentScoresToZero();
		return cards.drawAll();
	}
	
	/* void render() {
		
	} */
}
