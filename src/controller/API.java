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
		GameController.startGame(playerQuantity);
	}
}
