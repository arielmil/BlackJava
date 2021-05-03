/***********************************************************************/

package model;

/***********************************************************************/

class Player extends AbstractPlayer {
	Bet bet;
	Tokens tokens_array[];
	boolean insurance;
	boolean isBetting;
	
	/***************************************************************************
	*  Method: Constructor - Player : Initializes the Player
	*  ****/
	
	Player(String name){
		super(name);
		bet = new Bet();
		initializeTokensArray();
		insurance = false;
		isBetting = false;
	}
	
	/* End Method: Constructor - Player */
	
	void appendTokens(List tokensList) {
		int i;
		Tokens tokens;
		
		for(i = 0; i < tokensList.getSize(); i++) {
			
			tokens = (Tokens) tokensList.drawL();
			tokens_array[tokenToIndex(tokens.getToken())].tokensAdd(tokens);
		}	
	}
	
	void insurance() {
		insurance = true;
	}
	
	boolean getInsurance() {
		return insurance;
	}
	
	void endTurn() {
		insurance = false;
	}
	
	void appendHand() {
		Hand hand = new Hand();
		getHand().insertL(hand);
	}
	
	void subtractTokensFromBet(Token token) {
		bet.subtractToken(tokens_array[tokenToIndex(token)].tokensSubtract());
	}
	
	void addTokensToBet(Token token) {
		bet.addToken(tokens_array[tokenToIndex(token)].tokensSubtract());
	}
	
	void finishBet() {
		isBetting = false;
	}
	
	void bet(int option, Token token) {
		
		isBetting = true;
		while(isBetting) {
			if (option == 0) {
				subtractTokensFromBet(token);
			}
			else {
				addTokensToBet(token);
			}
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
		int token_values[] = new int[] {1, 5, 10, 20, 50, 100};
		
		int i;
		for (i = 0; i < 6; i++) {
			tokens_array[i] = new Tokens(new Token(token_values[i], token_names[i]), token_quantities[i], (token_quantities[i] * token_values[i]));
		}
	}
	
}