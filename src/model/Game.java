package model;

class Game {
	private Player players[];
	private Deck deck;
	private Dealer dealer;
	private Bet turn_bet;
	private Player who_made_blackjack[];
	private Player winners[];
	
	Game() {
		
		deck = new Deck();
	}
	
	public Player[] winningOrder() {
		return winners;
	}
}
