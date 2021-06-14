// Ariel Mileguir
// Pedro Gabriel 

package controller;

import view.BlackJavaFrame;

public class GameController {
    
	private static BlackJavaFrame mainFrame;
    
	public GameController () {
		mainFrame = new BlackJavaFrame();
	}
	

    public static void startGame (int playerQuantity, String playerNames[]) {
    	mainFrame.startGame(playerQuantity, playerNames);
    }
    
    public static void playerStand() {
    	mainFrame.playerStand();
    }
    
    public static void main(String args[]) {
    	@SuppressWarnings("unused")
		GameController teste = new GameController();

    }
    
    public static void quitGame() {
    	mainFrame.quitGame();
    }

    public static void setPlayerScore(int score, int playerNumber, int handNumber) {
    	mainFrame.setPlayerScore(score, playerNumber, handNumber);
    }

    public static void dealCard(int playerNumber, String cardName) {
    	mainFrame.dealCard(playerNumber, cardName);
    }
}
