package model;

public class Player extends AbstractPlayer {
	Bet bet;
	private List tokens_list;
	private int total_money;
	private boolean insurance;
	private boolean isBetting;
	
	public Player(String name){
		super(name);
		bet = new Bet();
		initializeTokensList();
		insurance = false;
		isBetting = false;
		total_money = 500;
	}
	
	
	public void addTokens(List tokens_list) {
		int i;
		Tokens tokens;
		Tokens my_tokens;
		
		for(i = 0; i < tokens_list.getSize(); i++) {
			
			tokens = (Tokens) tokens_list.get(i);
			
			my_tokens = (Tokens)this.tokens_list.acess(tokens);
			
			my_tokens.tokensAdd(tokens);
			total_money = total_money + tokens.getValue();
		}
		
	}
		
	public void insurance() {
		insurance = true;
	}
	
	public boolean getInsurance() {
		return insurance;
	}
	
	public void endTurn() {
		insurance = false;
		super.endTurn();
	}
	
	public List prepareNextTurn() {
		bet.clear();
		return super.prepareNextTurn();
	}
		
	public void betToken(Tokens token) {
		( (Tokens)tokens_list.acess(token) ).tokenSubtract();
		bet.addTokens(token.getColor());
		total_money = total_money - token.getValue();
	}
	
	public void unbetToken(Tokens token) {
		Tokens toAdd = bet.subtractTokens(token);
		( (Tokens)tokens_list.acess(token) ).tokensAdd(toAdd);
		total_money = total_money + token.getValue();
	}
			
	public void toggleIsBetting() {
		isBetting = !isBetting;
	}
	
	public boolean isBetting() {
		return isBetting;
	}
	
	public boolean bet(Tokens token, boolean bet) {
		
		if (bet) {
			betToken(token);
		}
		
		else {
			unbetToken(token);
		}
		
		return true;
	}
		
	public void Split(Card card1, Card card2) {
		Hand hands = (Hand)super.getHands().get(0);
		if (getIsPlaying()) {
			if (super.hands.getSize() == 2) {
				if(hands.canSplit() && canDouble()) {
					doubleBet();
					appendHand(card1, card2);
				}	
			}
		}
		
		else {
			return;
		}
	}
	
	/* Escolhe a Hand que quer dar Double */
	public void Double(Card card, Hand hand) {
		if (getIsPlaying()) {
			if (canDouble()) {
				doubleBet();
				hit(card, hand);
				hand.stop();
			}
		}
		
		else {
			return;
		}
	}
	
	public void Surrender() {
		if (getIsPlaying()) {
			
			endTurn();
			getHalfBetBack();
		}
		else {
			return;
		}
	}
	
	public void hit(Card card, Hand hand) {
		takeCard(card, hand);
	}
	
	/* Utils */
	public void appendHand(Card card1, Card card2) {
		Hand new_hand = new Hand();
		
		takeCard(card1, new_hand);
		takeCard(card2, new_hand);
		
		getHands().insertL(new_hand);
	}
	
	public void getHalfBetBack() {
		int half_bet = bet.getTotalValue()/2;
		List tokens = bet.subtractTokensFromValue(half_bet);	
		addTokens(tokens);
		total_money = total_money + half_bet;
	}
		
	public void initializeTokensList() {
		tokens_list = new List();
		String token_names[] = new String[] {"Gray", "Purple", "Blue", "Red", "Green", "Black"};
		int token_quantities[] = new int[] {10, 8, 5, 5, 2, 2};
		
		int i;
		for (i = 0; i < 6; i++) {
			tokens_list.insertL(new Tokens(token_names[i], token_quantities[i]));
		}
				
	}
		
	public boolean canDouble() {
		if (total_money >= bet.getTotalValue() * 2) {
			return true;
		}
		
		return false;
	}
	
	public void setTotalMoney (int value) {
		total_money= total_money + value;
	}
	
	public void setReduceTotalMoney (int value) {
		total_money= total_money - value;
	}
	
		
	public void doubleBet() {
		int totalValue = bet.getTotalValue(), i;
		List tokens;
		Tokens token;
		
		total_money = total_money - totalValue;
		totalValue = totalValue * 2;
		
		tokens = Tokens.convertValueToTokens(totalValue);
		
		for (i = 0; i < tokens.getSize(); i++) {
			token = ( (Tokens)tokens_list.acess(tokens) ).tokensSubtract( ((Tokens)tokens.get(i)).getQuantity() );
			bet.addTokens(token.getColor(), token.getQuantity());
		}
		
	}
	
	public int getTotalMoney() {
		return total_money;
	}
	
	public Bet getBet() {
		return bet;
	}
}