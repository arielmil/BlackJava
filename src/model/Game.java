// Ariel Mileguir
// Pedro Gabriel 

package model;

public class Game {
	private Player players[];
	
	Game(Player players[]) {
		int i;
		int playersQuantity = players.length;
		this.players = new Player[playersQuantity];
		
		for (i = 0; i < playersQuantity; i++) {
			this.players[i] = players[i];
		}
	}
	
	public void addToPlayerBalance(int playerNumber, int value) {
		players[playerNumber].setTotalMoney(value);
	}
	
	public void betPlayerToken(int playerNumber, String tokenColor) {
		int i;
		 int index = 0;
		 int token_value;
		 int tokensValues[] = new int[] {1, 5, 10, 20, 50, 100};
		 String[] tokensNames = new String[] {"Gray", "Purple", "Blue", "Red", "Green", "Black"};
		 for (i = 0; i < 6; i++) {
			 if(tokensNames[i] == tokenColor )
			 {
				 index = i;
			 }
		 }	 
		token_value = tokensValues[index];
		players[playerNumber].bet.addTokens(tokenColor);
		players[playerNumber].setReduceTotalMoney(token_value);
		
	}
	
	public void unbetPlayerToken(int playerNumber, String tokenColor) {
		int i;
		 int index = 0;
		 int token_value;
		 int tokensValues[] = new int[] {1, 5, 10, 20, 50, 100};
		 String[] tokensNames = new String[] {"Gray", "Purple", "Blue", "Red", "Green", "Black"};
		 for (i = 0; i < 6; i++) {
			 if(tokensNames[i] == tokenColor )
			 {
				 index = i;
			 }
		 }	 
		token_value = tokensValues[index];
		Tokens tokens = new Tokens (tokenColor,1);
		players[playerNumber].bet.subtractTokens(tokens);
		players[playerNumber].setTotalMoney(token_value);
		
		
	}
	
	
}
