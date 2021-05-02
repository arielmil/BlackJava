package model;

class Tokens {
	private Token token;
	private int quantity;
	private int total;
	/*private img*/
	
	Tokens(Token token, int quantity, int total) {
		this.token = token;
		this.quantity = quantity;
		this.total = total;
	}
	
	int getQuantity() {
		return quantity;
	}
	
	Token getToken() {
		return token;
	}
		
	int getTotal() {
		return total;
	}
	
	void tokensAdd(Tokens tokens) {
		quantity = quantity + tokens.quantity;
		total = total + tokens.total;
	}
	
	private int findTotal(int quantity) {
		int i;
		int total = 0;
		for (i = 0; i < quantity; i++) {
			total = total + token.getValue();
		}
		return total;
	}
	
	Tokens tokensSubtract(int quantity) {
		int total = findTotal(quantity);
		
		Tokens returned = new Tokens(new Token(token.getValue(), token.getColor()), quantity, total);
		
		this.quantity = this.quantity - quantity;
		this.total = this.total - total;
		
		return returned;
	}
	
	/*void render() {
		
	}*/
}
