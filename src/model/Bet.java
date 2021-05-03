/***********************************************************************/

package model;

/***********************************************************************/

class Bet {
	private List tokens;
	private int totalValue;
	
	Bet() {
		tokens = new List();
		totalValue = 0;
	}
		
	int getTotalValue() {
		return totalValue;
	}
	
	List getTokens() {
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
