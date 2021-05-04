/***********************************************************************/

package model;

/***********************************************************************/

public class Tokens {
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
		Tokens returned = new Tokens(new Token(token.getColor()), quantity);
		
		this.quantity = this.quantity - quantity;
		setTotal();
		
		return returned;
	}
	
	public Token tokenSubtract() {
		quantity = quantity - 1;
		total = total - token.getValue();
		return new Token(token.getColor());
	}
	/* End Method: private int findTotal */
	
	public static List convertValueToTokens(int value) {
        int blackTokens, purpleTokens, greenTokens, blueTokens, redTokens, grayTokens;
        blackTokens = purpleTokens = greenTokens = blueTokens = redTokens = grayTokens = 0;
        
        int i;
        
        String token_names[] = new String[] {"Gray", "Red", "Blue", "Green", "Purple", "Black"};
        int token_quantities[] = new int[] {grayTokens, redTokens, blueTokens, greenTokens, purpleTokens, blackTokens};
  
        List result = new List ();
        
        if (value % 100 > 0) {
            blackTokens += value/100;
            value -= blackTokens * 100;
        }

        else if (value % 50 > 0) {
            purpleTokens += value/50;
            value -= purpleTokens * 50;
        }

        else if (value % 25 > 0) {
            greenTokens += value/25;
            value -= greenTokens * 25;
        }

        else if (value % 10 > 0) {
            blueTokens += value/10;
            value -= blueTokens * 10;
        }

        else if (value % 5 > 0) {
            redTokens += value/5;
            value -= redTokens * 5;
        }

        else if (value > 0) {
            grayTokens += value;
            value -= grayTokens;
        }

        for (i = 0; i < token_quantities.length; i++) {
        	result.insertL(new Tokens(new Token(token_names[i]), token_quantities[i]));
        }
   
        return result;

    }
	
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