package controller;

import view.BlackJavaFrame;

public class GameController {
    
	static BlackJavaFrame mainFrame;
    
	public GameController () {
		
		mainFrame = new BlackJavaFrame();
		
		
	}
	

    public static void startGame (int playerQuantity) {
    	
    	String playerNames[] = new String[] {"Player1","Player2","Player3","Player4"};
    	mainFrame.startGame(playerQuantity, playerNames);
    }
    
    public static void main(String args[]) {
    	
    	GameController teste = new GameController();

    }
    
}
