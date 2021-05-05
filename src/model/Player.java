/***********************************************************************/

package model;

/***********************************************************************/

/* Falta fazer algumas checagens de erro, e trocar os return -1 pelo uso de execoes */

public class Player extends AbstractPlayer {
	Bet bet;
	Tokens tokens_array[];
	int total_money;
	boolean insurance;
	boolean isBetting;
	
	/***************************************************************************
	*  Method: Constructor - Player : Initializes the Player
	*  ****/
	
	public Player(String name){
		super(name);
		bet = new Bet();
		initializeTokensArray();
		insurance = false;
		isBetting = false;
		total_money = 500;
	}
	
	/* End Method: Constructor - Player */
	
	public void addTokens(List tokensList) {
		int i;
		Tokens tokens;
		
		for(i = 0; i < tokensList.getSize(); i++) {
			
			tokens = (Tokens) tokensList.drawL();
			tokens_array[tokenToIndex(tokens.getToken())].tokensAdd(tokens);
		}	
	}
	
	public void insurance() {
		insurance = true;
	}
	
	public boolean getInsurance() {
		return insurance;
	}
	
	public void endTurn() {
		insurance = false;
		super.endTurn();
	}
	
	public void prepareNextTurn() {
		bet.clear();
	}
		
	public void betToken(Token token) {
		bet.addToken(tokens_array[tokenToIndex(token)].tokenSubtract());
		total_money = total_money - token.getValue();
	}
	
	public void unbetToken(Token token) {
		bet.subtractToken(token);
		total_money = total_money + token.getValue();
	}
	
	
	public void finishBet() {
		isBetting = false;
	}
	
	void bet(int option, Token token) {
		
		isBetting = true;
		while(isBetting) {
			if (option == 0) {
				unbetToken(token);
			}
			else {
				betToken(token);
			}
		}
	}
	
	void Split(Card card1, Card card2, int whichHand) {
		if (getIsPlaying()) {
			if (getHand().getSize() <= 2) {
				Hand hand = (Hand) getHand().get(whichHand);
				if(hand.canSplit() && canDouble()) {
					doubleBet();
					appendHand(card1, card2);
					
				}	
			}
			
		}
		
		else {
			return;
		}
	}
	
	/* Escolhe a Hand que quer dar Double */
	void Double(Card card, int whichHand) {
		if (getIsPlaying()) {
			if (canDouble()) {
				doubleBet();
				hit(card, whichHand);
				stand();
			}
			
		}
		
		else {
			return;
		}
	}
	
	void Surrender() {
		if (getIsPlaying()) {
			
			endTurn();
			getHalfBetBack();
		}
		else {
			return;
		}
	}
	
	/* Utils */
	private void appendHand(Card card1, Card card2) {
		int howManyHands = getHand().getSize();
		Hand new_hand = new Hand();
		
		
		hit(card1, howManyHands + 1);
		hit(card2, howManyHands + 1);
		
		getHand().insertL(new_hand);
	}
	
	private void getHalfBetBack() {
		int half_bet = bet.getTotalValue()/2;
		List getBack = Tokens.convertValueToTokens(half_bet);
		int i;
		Token token;
		
		for (i = 0; i < getBack.getSize(); i++) {
			token = (Token) getBack.drawL();
			tokens_array[tokenToIndex(token)].tokenAdd();
		}
		
	}
	
	private int tokenToIndex(Token token) {
		if (token.getValue() == 1) {
			return 0;
		}
		
		if (token.getValue() == 5) {
			return 1;
		}
		
		if (token.getValue() == 10) {
			return 2;
		}
		
		if (token.getValue() == 20) {
			return 3;
		}
		
		if (token.getValue() == 50) {
			return 4;
		}
		
		else {
			return 5;
		}
	}
	
	private void initializeTokensArray() {
		tokens_array = new Tokens[6];
		String token_names[] = new String[] {"Gray", "Red", "Blue", "Purple", "Black"};
		int token_quantities[] = new int[] {10, 8, 5, 5, 2, 2};
		
		int i;
		for (i = 0; i < 6; i++) {
			tokens_array[i] = new Tokens(new Token(token_names[i]), token_quantities[i]);
		}
	}
		
	private boolean canDouble() {
		if (total_money >= bet.getTotalValue() * 2) {
			return true;
		}
		
		return false;
	}
	
	private void doubleBet() {
		int totalValue = bet.getTotalValue(), i;
		List tokens;
		Token token;
		
		totalValue = totalValue * 2;
		
		tokens = Tokens.convertValueToTokens(totalValue);
		for (i = 0; i < tokens.getSize() - 1; i++) {
			token = (Token) tokens.drawL();
			bet.addToken(token);
		}
		
	}
}