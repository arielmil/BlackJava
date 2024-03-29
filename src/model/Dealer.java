// Ariel Mileguir
// Pedro Gabriel 

package model;

public class Dealer extends AbstractPlayer {
	public boolean FirstDrawIsTen;
	private boolean hasSeventeen;
	
	public Dealer() {
		super("Dealer");
		FirstDrawIsTen = false;
		hasSeventeen = false;
	}
	
	public boolean checkIsTen() {
		String first_card_name = ((Card)getHands().get(0)).getName();
		
		if(first_card_name == "Ten" || first_card_name == "Jack" || first_card_name == "Queen" || first_card_name == "King") {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	
	public void setIsTen(boolean bool) {
		FirstDrawIsTen = bool;
	}
	
	public boolean getIsTen() {
		return FirstDrawIsTen;
	}
	
	public void forceDraw(Deck deck) {
		if (!hasSeventeen) {
			deal(this, (Hand)this.getHands().get(0), deck);
		}
		else {
			/*Execao de Dealer nao compra mais*/
			return;
		}
	}
	
	public void deal(AbstractPlayer player, Hand hand, Deck deck) {
		Card card = deck.draw();
		player.takeCard(card, hand);
	}
	
	public void dealFirstCards(Deck deck, Player players[]) {
		Hand hand;
		Card card;
		for (Player player : players) {
			hand = (Hand)player.getHands().get(0);
			player.takeCard(deck.draw(), hand);
			player.takeCard(deck.draw(), hand);
		}
		
		hand = (Hand)this.getHands().get(0);
		this.takeCard(deck.draw(), hand);
		
		card = deck.draw();
		card.toggleReveal();
		
		this.takeCard(card, hand);
	}
}