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
	
	public Tokens(Token token, int quantity) {
		this.token = token;
		this.quantity = quantity;
		setTotal();
	}
	/* End Method: Constructor - Tokens */
	/*
	***************************************************************************
	*  Method: int getQuantity : Returns the amount of Tokens
	*  ****/
	
	public int getQuantity() {
		return quantity;
	}
	/* End Method: int getQuantity */
	/*
	***************************************************************************
	*  Method: Token getToken : Returns the Token Object
	*  ****/
	
	public Token getToken() {
		return token;
	}
	/* End Method: Token getToken */
	/*
	***************************************************************************
	*  Method: int getTotal : Returns the total amount of money that represents those Tokens
	*  ****/
		
	public int getTotal() {
		return total;
	}
	/* End Method: int getTotal */
	/*
	***************************************************************************
	*  Method: void tokensAdd : Add Player Tokens
	*  ****/
	
	public void tokensAdd(Tokens tokens) {
		quantity = quantity + tokens.quantity;
		total = total + tokens.total;
	}
	
	public void tokenAdd() {
		quantity++;
		total = total + token.getValue();
	}
	/* End Method: void tokensAdd */
	/*
	***************************************************************************
	*  Method: private int findTotal : Calculates how much Tokens will represent in cash
	*  ****/
	
	public void setTotal() {
		int i;
		int total = 0;
		for (i = 0; i < quantity; i++) {
			total = total + token.getValue();
		}
		this.total = total;
	}
	
	/* End Method: private int findTotal */
	/*
	***************************************************************************
	*  Method: Tokens tokensSubtract : Remove Player Tokens
	*  ****/
	
	public Tokens tokensSubtract(int quantity) {
		Tokens returned = new Tokens(new Token(token.getValue(), token.getColor()), quantity);
		
		this.quantity = this.quantity - quantity;
		setTotal();
		
		return returned;
	}
	
	public Token tokenSubtract() {
		quantity = quantity - 1;
		total = total - token.getValue();
		return new Token(token.getValue(), token.getColor());
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