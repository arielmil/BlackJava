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
	
	/*falta limpar, e tirar e somar no total_money */
	
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
		/*falta devolver tokens para o array*/
		total_money = total_money + token.getValue();
	}
	
	
	public void finishBet() {
		isBetting = false;
	}
	
	void bet(Token token, boolean bet) {
		
		if (bet) {
			betToken(token);
		}
		
		else {
			unbetToken(token);
		}
	}
	
	void Split(Card card1, Card card2, int whichHand) {
		Hand hand;
		if (getIsPlaying()) {
			if (getHand().getSize() <= 2) {
				hand = (Hand) getHand().get(whichHand);
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
		List tokens = bet.subtractTokensFromValue(half_bet);
		Token token;
		
		int i;
		for (i = 0; i < tokens.getSize(); i++) {
			token = ((Tokens) tokens.get(i)).getToken();
			tokens_array[tokenToIndex(token)].tokensAdd((Tokens) tokens.get(i));
		}
	}
	
	private int tokenToIndex(Token token) {
		int index;
		
		switch (token.getValue()) {
			case 1:
				index = 0;
				break;
				
			case 5:
				index = 1;
				break;
				
			case 10:
				index = 2;
				break;
				
			case 20:
				index = 3;
				break;
				
			case 50:
				index = 4;
				break;
				
			default:
				index = 5;
		}
		
		return index;
	}
	
	private void initializeTokensArray() {
		tokens_array = new Tokens[6];
		String token_names[] = new String[] {"Gray", "Red", "Blue", "Green", "Purple", "Black"};
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
		for (i = 0; i < tokens.getSize(); i++) {
			token = (Token) tokens.drawL();
			bet.addToken(token);
		}
		
	}
}