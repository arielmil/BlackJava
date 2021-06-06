package view;

import controller.API;

import java.awt.Image;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JPanel;

public class UpperGamePanel extends JPanel{
	private String cardNames[];
	private String cardSuitNames[];
	private String tokenNames[];
	private String playerName;
	
	private int playerScore;
	
	private Image cardsImages[];
	private Image tokensImages[];
	private Image deckImage;
	private Image cardsBinImage;
	
	private JButton quitButton;
	private JButton newTurnButton;
	private JButton saveGameButton;
		
	public UpperGamePanel(Point screenSize) {
		super();
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setOpaque(false);
		//loadImages();
	}
		
	private void loadImages() {
		int i = 0;
		String imgName;
		
		cardNames = API.getCardNames();
		cardSuitNames = API.getCardSuitNames();
		tokenNames = API.getTokensNames();
		
		for (String cardName : cardNames) {
			
			for (String suitName : cardSuitNames) {
				imgName = cardName + "_" + suitName + ".gif";
				cardsImages[i] = ImageLoader.load(imgName);
				i++;
			}
		}
		
		i = 0;
		for (String tokenName : tokenNames) {
			imgName = "Token" + tokenName + ".PNG";
			tokensImages[i] = ImageLoader.load(imgName);
			i++;
		}
		
		imgName = "deck2.gif";
		deckImage = ImageLoader.load(imgName);
		
		imgName = "deck1.gif";
		cardsBinImage = ImageLoader.load(imgName);
	}
	
}
