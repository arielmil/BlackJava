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
	
	void addToken(Token token) {
		tokens.insertL(token);
		totalValue = totalValue + token.getValue();
	}
	
	void subtractToken(Token token) {
		tokens.drawL();
		totalValue = totalValue - token.getValue();
	}
	
	void clear() {
		tokens.clear();
		totalValue = 0;
	}
}
