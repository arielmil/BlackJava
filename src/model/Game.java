package model;

class Game {
	private Player players[];
	private Deck deck;
	private Dealer dealer;
	private Bet turn_bet;
	private Player winners[];
	private Player players_in_turn[];
	private Player tied_with_dealer[];
	
	Game() {
		
		deck = new Deck();
	}
	
	public Player[] winningOrder() {
		return winners;
	}
	
	public Player[] getGameWinner() {
		return winners;
	}
	
	public void decideWinners() {
		Player winner = players[0];
		int winner_index = 0;
		
		int i, j = 1;
		for (i = 1; i < winners.length; i++) {
			if (players[i].getTotalMoney() > winner.getTotalMoney()) {
				winner = players[i];
				winner_index = i;
			}
		}
		
		winners[0] = winner;
		
		if (winners.length > 1) {
			for (i = 1; i < winners.length; i++) {
				if (players[i].getTotalMoney() == winner.getTotalMoney() && i != winner_index) {
					winners[j] = players[i];
					j++;
				}
			}
		}
	}
	
	public boolean drawPhase() {
		Hand hand;

		dealer.dealFirstCards(deck, players_in_turn);
		hand = (Hand)dealer.getHands().get(0);
		hand.countScore(true);
		
		if (hand.getIsBlackJack()) {
			dealer.turnWinner();
		}
		
		for (Player player : players_in_turn) {
			
			hand = (Hand)player.getHands().get(0);
			hand.countScore(true);
			
			if (hand.getIsBlackJack()) {
				player.turnWinner();
			}
		}
		
		return true;
	}
	
	/* colocar em um while no controller */
	public boolean bet(Player player, Tokens tokens, boolean true_for_bet) {
		return player.bet(tokens, true_for_bet);
	}
	
	public boolean results() {
		for (Player player : players_in_turn) {
			
		}
		return true;
	}
}
