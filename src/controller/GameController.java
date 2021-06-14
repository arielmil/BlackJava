// Ariel Mileguir
// Pedro Gabriel 

package controller;

import view.BlackJavaFrame;

public class GameController {
    
	static BlackJavaFrame mainFrame;
    
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
    	
    	GameController teste = new GameController();

    }
    
}
