// Ariel Mileguir
// Pedro Gabriel 

package controller;


import model.Deck;
import model.Model;
import model.Player;

public class API {
	private static String cardNames[];
	private static String cardsSuitNames[];

	static {
		cardNames = new String[13];
		cardsSuitNames = new String[14];
		
		cardNames = Model.getCardNames();
		cardsSuitNames = Model.getCardSuitNames();
	}
	
	private static void dealCard(int playerNumber, String cardName) {
		GameController.dealCard(playerNumber, cardName);
	}
	
	public static int[] getCardValues() {
		return Model.getCardValues();
	}
	
	public static int[] getTokensValues() {
		return Model.getTokensValues();
	}
	
	public static String[] getCardNames() {
		return cardNames;
	}
	
	public static String[] getCardSuitNames() {
		return cardsSuitNames;
	}
	
	public static String[] getTokensNames() {
		return Model.getTokensNames();
	}
	
	public static void startGame (int playerQuantity) {
		Model.startGame(playerQuantity);
		GameController.startGame(playerQuantity, Model.getPlayerNames(), Model.getPlayersBalance());
	}
	
	public static void loadGame (Deck deck, Player players[]) {
		Model.loadGame(deck, players);
		GameController.startGame(players.length, Model.getPlayerNames(), Model.getPlayersBalance());

	}
	
	public static void playerHit(int playerNumber, int handNumber) {
		String cardName = Model.playerHit(playerNumber, handNumber);
		dealCard(playerNumber, cardName);
	}
	
	public static void playerSurrender(int playerNumber) {
		Model.playerSurrender(playerNumber);
		playerStand(playerNumber);
	}
	
	public static void playerDouble(int playerNumber, int handNumber) {
		Model.playerDouble(playerNumber, handNumber);

		updatePlayerBet(playerNumber);

	}
	
	public static void playerSplit(int playerNumber) {
		Model.playerSplit(playerNumber);
		playerHit(playerNumber, 2);
		playerHit(playerNumber, 2);
		updatePlayerBet(playerNumber);
	}
	
	public static void playerStand(int playerNumber) {
		GameController.playerStand();
	}
	
	//Ver mecanica de bet e unbet e os cliques na interface grafica para bet e unbet !!!
	public static void playerBet(int playerNumber, String tokenColor) {
		Model.betPlayerToken(playerNumber, tokenColor);
		GameController.setPlayerBet(playerNumber, playerNumber);
	}
	
	public static void quitGame() {
		GameController.quitGame();
	}
	
	public static void updatePlayerScore(int playerNumber) {
		int score, handsQuantity;
		int i; 
		
		handsQuantity = Model.getPlayerHandsQuantity(playerNumber);
		
		for (i = 0; i < handsQuantity; i++) {
			score = Model.getPlayerScore(playerNumber, i);
			GameController.setPlayerScore(score, playerNumber, 1);
		}
		
	}
	
	public static void updatePlayerBalance(int playerNumber) {
		int balance = Model.getPlayerBalance(playerNumber);
		GameController.setPlayerBalance(balance, playerNumber);
	}
	
	public static void updatePlayerBet(int playerNumber) {
		int bet = Model.getPlayerBet(playerNumber);
		GameController.setPlayerBet(bet, playerNumber);
	}
}

