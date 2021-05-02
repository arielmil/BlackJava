/***********************************************************************/

package model;

/***********************************************************************/

class Tokens {
	private Token token;
	private int quantity;
	private int total;
	/*private img*/
	
	/***************************************************************************
	*  Method: Constructor - Tokens : Initializes the Tokens
	*  ****/
	
	Tokens(Token token, int quantity, int total) {
		this.token = token;
		this.quantity = quantity;
		this.total = total;
	}
	/* End Method: Constructor - Tokens */
	/*
	***************************************************************************
	*  Method: int getQuantity : Returns the amount of Tokens
	*  ****/
	
	int getQuantity() {
		return quantity;
	}
	/* End Method: int getQuantity */
	/*
	***************************************************************************
	*  Method: Token getToken : Returns the Token Object
	*  ****/
	
	Token getToken() {
		return token;
	}
	/* End Method: Token getToken */
	/*
	***************************************************************************
	*  Method: int getTotal : Returns the total amount of money that represents those Tokens
	*  ****/
		
	int getTotal() {
		return total;
	}
	/* End Method: int getTotal */
	/*
	***************************************************************************
	*  Method: void tokensAdd : Add Player Tokens
	*  ****/
	
	void tokensAdd(Tokens tokens) {
		quantity = quantity + tokens.quantity;
		total = total + tokens.total;
	}
	/* End Method: void tokensAdd */
	/*
	***************************************************************************
	*  Method: private int findTotal : Calculates how much Tokens will represent in cash
	*  ****/
	
	private int findTotal(int quantity) {
		int i;
		int total = 0;
		for (i = 0; i < quantity; i++) {
			total = total + token.getValue();
		}
		return total;
	}
	/* End Method: private int findTotal */
	/*
	***************************************************************************
	*  Method: Tokens tokensSubtract : Remove Player Tokens
	*  ****/
	
	Tokens tokensSubtract(int quantity) {
		int total = findTotal(quantity);
		
		Tokens returned = new Tokens(new Token(token.getValue(), token.getColor()), quantity, total);
		
		this.quantity = this.quantity - quantity;
		this.total = this.total - total;
		
		return returned;
	}
	/* End Method: private int findTotal */
	/*
	****************************************************************************
	 * 
	 * To be implemented...
	 * 
	 * Method: void render: Render the image of the Token on the Screen.
	 *  ****/
	/*void render() {
	
	
	}*/
	/* End Method: void render */
}