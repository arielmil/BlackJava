package controller;

import view.BlackJavaFrame;

public class GameController {
    
	static BlackJavaFrame mainFrame;
    
	public GameController () {
		
		mainFrame = new BlackJavaFrame();
		
		
	}
	
    public void funcao1 (int playerQuantity) {
    	
    	mainFrame.startGame(playerQuantity);
    	
    	
    }
    
    public static void main(String args[]) {
    	
    	GameController teste = new GameController();
    	
    	
    }
    
}
