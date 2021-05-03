package model;

class Hand {
	private List cards;
	private int CurrentScore;
	private boolean isBroke;
	private boolean isBlackJack;
	private boolean stopDraw;
	private boolean isTwentyOne;
	
	Hand() {
		cards = new List();
		isBroke = false;
		isBlackJack = false;
		stopDraw = false;
		isTwentyOne = false;
		setCurrentScoresToZero();
	}
	
	void setCurrentScore() {
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
	
	int getCurrentScore() {
		return CurrentScore;
	}
	
	boolean isBroke() {
		return isBroke;
	}
	
	void setIsBlackJack() {
		isBlackJack = true;
	}
	
	boolean getIsBlackJack() {
		return isBlackJack;
	}
	
	
	void seventeenPoints() {
		stopDraw = true;
	}
	
	boolean canDraw() {
		return stopDraw;
	}
	
	void twentyOnePoints() {
		isTwentyOne = true;
	}
	
	boolean getIsTwentyOne() {
		return isTwentyOne;
	}
	
	void setCurrentScoresToZero() {
		CurrentScore = 0;
		isBroke = false;
		isBlackJack = false;
		stopDraw = false;
		isTwentyOne = false;
	}
	
	void addCard(Card card) {
		cards.insertL(card);
	}
	
	/* void render() {
		
	} */
}
