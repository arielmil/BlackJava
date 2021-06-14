// Ariel Mileguir
// Pedro Gabriel 

package model;

public class Model {
	
	private static Player players[];
	private static Game game;
	private static Dealer dealer;
	private static Deck deck = new Deck();
	
	private static Hand getPlayerHand(int playerNumber, int handNumber) {
		return (Hand)players[playerNumber].getHands().get(handNumber);
	}
	
	public static String[] getPlayerNames() {
		int i;
		String playerNames[] = new String[players.length];
		
		for (i = 0; i < players.length; i++) {
			playerNames[i] = players[i].getName();
		}
		
		return playerNames;
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
	
	public static void startGame(int playerQuantity) {
		initializePlayers(playerQuantity);
		game = new Game(players);
	}
	
	public static void betPlayerToken(int playerNumber, int tokenColor) {
		players[playerNumber].bet(null, true);
	}
	
	public static void unbetPlayerToken(int playerNumber, int tokenColor) {
		players[playerNumber].bet(null, false);
	}

	public static void addToPlayerBalance(int playerNumber, int value) {
		game.addToPlayerBalance(playerNumber, value);
	}
	
	public static String playerHit(int playerNumber, int handNumber) {
		String cardFullName;
		Card card = deck.draw();
		
		players[playerNumber].hit(card, getPlayerHand(playerNumber, handNumber));
		cardFullName = card.getName() + "_" + card.getSuitname();
		
		return cardFullName;
	}
	
	public static void playerSurrender(int playerNumber) {
		players[playerNumber].Surrender();
	}

	public static void playerDouble(int playerNumber, int handNumber) {
		players[playerNumber].Double(deck.draw(), getPlayerHand(playerNumber, handNumber));
	}
	
	public static void playerSplit(int playerNumber) {
		players[playerNumber].Split(deck.draw(), deck.draw());
	}

	public void dealFirstCards(Player playersInTurn[]) {
		dealer.dealFirstCards(deck, playersInTurn);
	}
}
