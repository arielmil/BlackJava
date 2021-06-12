/***********************************************************************/

package model;

/***********************************************************************/

public class Bet {
	public List tokens;
	public int totalValue;
	
	public Bet() {
		tokens = new List();
		totalValue = 0;
	}
		
	public int getTotalValue() {
		return totalValue;
	}
	
	public List getTokens() {
		return tokens;
	}
	
	public void addTokens(String color) {
		Tokens tokens = new Tokens(color, 1);
		this.tokens.insertL(tokens);
		totalValue = totalValue + tokens.getValue();
	}
	
	public void addTokens(String color, int i) {
		Tokens tokens = new Tokens(color, i);
		this.tokens.insertL(tokens);
		totalValue = totalValue + i*tokens.getValue();
	}
	
	public Tokens subtractTokens(Tokens token) {
		Tokens tokens = (Tokens)this.tokens.drawL();
		totalValue = totalValue - token.quantity*token.getValue();
		return tokens;
	}
	
	public List subtractTokensFromValue(int tokens_value) {
		List tokens = Tokens.convertValueToTokens(tokens_value);
		
		int i;
		for (i = 0; i < tokens.getSize(); i++) {
			this.tokens.draw(tokens.get(i));
		}
		
		totalValue = totalValue - tokens_value;
		return tokens;
		
	}
	
	public void clear() {
		tokens.clear();
		totalValue = 0;
	}
}
