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
	
	
	
}
