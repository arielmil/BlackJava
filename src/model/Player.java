/***********************************************************************/

package model;

/***********************************************************************/

class Player extends AbstractPlayer {
	Bet bet;
	Tokens tokens_array[];
	int total_money;
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
		total_money = 500;
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
		total_money = total_money - token.getValue();
	}
	
	void addTokensToBet(Token token) {
		bet.addToken(tokens_array[tokenToIndex(token)].tokensSubtract());
		total_money = total_money - token.getValue();
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
	
	void Split() {
		if (getHand().getSize() <= 2) {
			Hand hand = (Hand) getHand().get(0);
			if(hand.canSplit() && canDouble()) {
				doubleBet();
				
			}	
		}
	}
	
	/* Utils */
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
	
	private List convertValueToTokens(int value) {
        int blackTokens = 0;
        int purpleTokens = 0;
        int greenTokens = 0;
        int blueTokens = 0;
        int redTokens = 0;
        int grayTokens = 0;

        if (value % 100 > 0) {
            blackTokens += value/100;
            value -= blackTokens * 100;
        }

        if (value % 50 > 0) {
            purpleTokens += value/50;
            value -= purpleTokens * 50;
        }

        if (value % 25 > 0) {
            greenTokens += value/25;
            value -= greenTokens * 25;
        }

        if (value % 10 > 0) {
            blueTokens += value/10;
            value -= blueTokens * 10;
        }

        if (value % 5 > 0) {
            redTokens += value/5;
            value -= redTokens * 5;
        }

        if (value > 0) {
            grayTokens += value;
            value -= grayTokens;
        } else {}

        List result = new List ();

        result.insertL(blackTokens);
        result.insertL(purpleTokens);
        result.insertL(greenTokens);
        result.insertL(blueTokens);
        result.insertL(redTokens);
        result.insertL(grayTokens);

        return result;

    }
	
	private boolean canDouble() {
		if (total_money >= bet.getTotalValue() * 2) {
			return true;
		}
		
		return false;
	}
	
	private void doubleBet() {
		if (canDouble()) {
			int totalValue = bet.getTotalValue(), i;
			List tokens;
			Token token;
			
			totalValue = totalValue * 2;
			
			tokens = convertValueToTokens(totalValue);
			for (i = 0; i < tokens.getSize(); i++) {
				token = (Token) tokens.drawL();
				bet.addToken(token);
			}
			
		}
		
		else {
			return;
		}
	}
	
}