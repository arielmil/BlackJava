package model;

public class Hand {
	public List cards;
	public int score;
	public boolean isBusted;
	public boolean isBlackJack;
	public boolean stopDraw;
	private boolean canSplit;
	private boolean stoppedThisTurn;
	
	public Hand() {
		cards = new List();
		setScoreToZero();
	}
	
	public void countScore(boolean isDrawPhase) {
		int i,j=0;
		
		Card card;
		for (i = 0; i < cards.getSize(); i++) {
			card = (Card)cards.get(i);
			
			score = score + card.getValue();
			if(score>21)
			{
				score = 0;
				for (j = 0; j < cards.getSize(); j++) {
					card = (Card)cards.get(j);
					if (card.getName() == "Ace") {
						score = score-10;
					}
					score = score + card.getValue();
				}
			}
		}
		
		if (score > 21) {
				isBusted = true;
		}
		
		else if (score == 21 && isDrawPhase) {
			isBlackJack = true;
		}
		
	}
	
	public int getScore() {
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
	
	public boolean getCanSplit() {
		return canSplit;
	}
	
	public boolean getStoppedThisTurn() {
		return stoppedThisTurn;
	}
	
	public void addCard(Card card) {
		cards.insertL(card);
	}
	
	public boolean canSplit() {
		Card first_card = (Card)cards.get(0);
		Card second_card = (Card)cards.get(1);
		if (cards.getSize() == 2 && (first_card.getName()==second_card.getName())) {
			canSplit = true;
		}
		
		return canSplit;
	}
	
	public void stop() {
		stoppedThisTurn = true;
	}
	
	public List clear() {
		setScoreToZero();
		return cards.drawAll();
	}
	
	public String[] getCards() {
		int i;
		int size = cards.getSize();
		String cardsNames[] = new String[size];
		
		for (i = 0; i < size; i++) {
			cardsNames[i] = ((Card)(cards.get(i))).getName();
		}
		
		return cardsNames;
	}
	
	/* void render() {
		
	} */
}
