package model;

class Hand {
	private List cards;
	private int CurrentScore;
	private boolean isBroke;
	private boolean isBlackJack;
	private boolean stopDraw;
	private boolean isTwentyOne;
	private boolean canSplit;
	
	public Hand() {
		cards = new List();
		isBroke = false;
		isBlackJack = false;
		stopDraw = false;
		isTwentyOne = false;
		canSplit = false;
		setCurrentScoresToZero();
	}
	
	public void setCurrentScore() {
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
	
	public boolean isBroke() {
		return isBroke;
	}
	
	public void setIsBlackJack() {
		isBlackJack = true;
	}
	
	public boolean getIsBlackJack() {
		return isBlackJack;
	}
	
	
	public void seventeenPoints() {
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
	
	/* void render() {
		
	} */
}
