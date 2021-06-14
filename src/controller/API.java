package controller;

import model.Model;

public class API {
	
	public static String[] getCardNames() {
		return Model.getCardNames();
	}
	
	public static String[] getCardSuitNames() {
		return Model.getCardSuitNames();
	}
	
	public static int[] getCardValues() {
		return Model.getCardValues();
	}
	
	public static int[] getTokensValues() {
		return Model.getTokensValues();
	}
	
	public static String[] getTokensNames() {
		return Model.getTokensNames();
	}
	
	public static void startGame (int playerQuantity) {
		Model.startGame(playerQuantity);
		GameController.startGame(playerQuantity, Model.getPlayerNames());
	}
	
	public static void playerHit(int playerNumber, int handNumber) {
		Model.playerHit(playerNumber, handNumber);
	}
	
	public static void playerSurrender(int playerNumber) {
		Model.playerSurrender(playerNumber);
	}
	
	public static void playerDouble(int playerNumber, int handNumber) {
		Model.playerDouble(playerNumber, handNumber);
	}
	
	public static void playerSplit(int playerNumber) {
		Model.playerSplit(playerNumber);
	}
	
	public static void playerStand(int playerNumber) {
		GameController.playerStand();
	}
	
}
