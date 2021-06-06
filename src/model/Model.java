package model;

public class Model {
	private static Deck deck = new Deck();;
		
	public static String[] getCardNames() {
		return deck.getCardNames();
	}
	
	public static String[] getCardSuitNames() {
		return deck.getCardSuitNames();
	}
	
	public static int[] getCardValues() {
		return deck.getCardValues();
	}
	
	public static int[] getTokensValues() {
		return Tokens.getTokensValues();
	}
	
	public static String[] getTokensNames() {
		return Tokens.getTokensNames();
	}
}
