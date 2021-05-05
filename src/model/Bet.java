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
	
	public List subtractTokens(int tokenQuantity) {
		List tokens = Tokens.convertValueToTokens(tokenQuantity);
		int i;
		
		for (i = 0; i < tokens.getSize(); i++) {
			/*fazer testes de retirar no meio de arrayList e ver se os elementos a direita "caem"*/
		}
		
		return tokens;
		
	}
	
	public void clear() {
		tokens.clear();
		totalValue = 0;
	}
}
