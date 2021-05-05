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
	
	public void addToken(Token token) {
		tokens.insertL(token);
		totalValue = totalValue + token.getValue();
	}
	
	public void subtractToken(Token token) {
		tokens.drawL();
		totalValue = totalValue - token.getValue();
	}
	
	public List subtractTokensFromValue(int tokens_value) {
		List tokens = Tokens.convertValueToTokens(tokens_value);
		
		int i;
		for (i = 0; i < tokens.getSize(); i++) {
			this.tokens.remove(tokens.get(i));
		}
		
		totalValue = totalValue - tokens_value;
		return tokens;
		
	}
	
	public void clear() {
		tokens.clear();
		totalValue = 0;
	}
}
