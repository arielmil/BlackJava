package model;

public class Model {
	
	private static Player players[];
	private static Dealer dealer;
	private static Deck deck = new Deck();
	
	private static Hand getPlayerHand(int playerNumber, int handNumber) {
		return (Hand)players[playerNumber].getHands().get(handNumber);
	}
	
	public static String[] getCardNames() {
		return deck.getCardNames();
	}
	
	public static String[] getCardSuitNames() {
		return deck.getCardSuitNames();
	}
	
	public static String[] getTokensNames() {
		return Tokens.getTokensNames();
	}
	
	public static String[] getPlayerCards(int playerNumber, int handNumber) {
		Hand hand = getPlayerHand(playerNumber, handNumber);
		return hand.getCards();
	}
	
	public static int[] getCardValues() {
		return deck.getCardValues();
	}
	
	public static int[] getTokensValues() {
		return Tokens.getTokensValues();
	}
		
	public static void initializePlayers(int playerQuantity) {
		int i;
		players = new Player[playerQuantity];
		
		for (i = 0; i < playerQuantity; i++) {
			players[i] = new Player("Player" + String.valueOf(i));
		}
		
		dealer = new Dealer();
	}

	public static int getPlayerBalance(int playerNumber) {
		return players[playerNumber].getTotalMoney();
	}

	public static int getPlayerBet(int playerNumber) {
		return players[playerNumber].getBet().getTotalValue();
	}

	public static int getPlayerScore(int playerNumber, int handNumber) {
		return getPlayerHand(playerNumber, handNumber).getScore();
	}

	public static void betPlayerToken(int playerNumber, int token) {
		
	}
}
