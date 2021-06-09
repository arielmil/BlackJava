package view;

import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.API;

//Ver primeiro comentario em UpperGamePanel
//Criar um método que escala uma coordenada x e y baseado em um tamanho de tela (largura x altura) para escalar todos os elementos dessa classe de acordo com o tamanho de tela utilizado.
@SuppressWarnings("serial")
abstract class AbstractGamePanel extends JPanel {
	private JPanel infoPanel;
	private JLabel infoLabel;

	Boolean debugPositioningMode = false;
	
	int playerScore;
	
	String playerName;

	String cardNames[];
	String cardSuitNames[];
	String tokenNames[];
	
	Image deckImage;
	
	Image cardsImages[];
	Image tokensImages[];
	
	Point screenSize;
	Point center;
	Point buttonsSize;
	Point buttonsLocation;
	Point cardsSize;
	Point tokensSize;
	
	public AbstractGamePanel(Point screenSize, String playerName) {
		super();
		
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setOpaque(false);
		
		this.screenSize = screenSize;
		center = new Point(screenSize.x/2, screenSize.y/2);
		
		this.playerName = playerName;
		
		buttonsSize = new Point(148, 45);
		
		infoPanel = new JPanel(null);
		infoPanel.setBounds(936, 0, 264, 45);
		add(infoPanel);
				
		infoLabel = new JLabel();
		infoLabel.setText(String.format("%s is Playing. Score: 0", playerName));
		infoLabel.setBounds(38, 0, 264, 45);
		infoPanel.add(infoLabel);
		
		loadImages();
	}
	
	public AbstractGamePanel(Point screenSize, String playerName, Boolean debugPositioningMode) {
		super();
		
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setOpaque(false);
		
		this.screenSize = screenSize;
		center = new Point(screenSize.x/2, screenSize.y/2);
		
		this.playerName = playerName;
		
		buttonsSize = new Point(148, 45);
		
		infoPanel = new JPanel(null);
		infoPanel.setBounds(936, 0, 264, 45);
		add(infoPanel);
		
		infoLabel = new JLabel();
		infoLabel.setText(String.format("%s is Playing. Score: 0", playerName));
		infoLabel.setBounds(38, 0, 264, 45);
		infoPanel.add(infoLabel);
		
		loadImages();
		
		this.debugPositioningMode = debugPositioningMode;
	}
	
	void loadImages() {
		int i = 0;
		String imgName;
		
		String localCardNames[] = API.getCardNames();
		String localCardSuitNames[] = API.getCardSuitNames();
		String localTokenNames[] = API.getTokensNames();
		
		cardNames = new String[localCardNames.length];
		cardSuitNames = new String[localCardSuitNames.length];
		tokenNames = new String[localTokenNames.length];
		
		cardNames = localCardNames;
		cardSuitNames = localCardSuitNames;
		tokenNames = localTokenNames;
		
		cardsImages = new Image[cardNames.length * cardSuitNames.length];
		
		for (String cardName : cardNames) {
			
			for (String suitName : cardSuitNames) {
				imgName = cardName + "_" + suitName + ".gif";
				cardsImages[i] = ImageLoader.load(imgName);
				i++;
			}
		}
		
		tokensImages = new Image[tokenNames.length];
		
		i = 0;
		for (String tokenName : tokenNames) {
			imgName = "Token_" + tokenName + "_Transparent" + ".png";
			tokensImages[i] = ImageLoader.load(imgName);
			i++;
		}
		
		cardsSize = new Point(cardsImages[0].getWidth(null), cardsImages[0].getHeight(null));
		tokensSize = new Point(tokensImages[0].getWidth(null), tokensImages[0].getHeight(null));
		
		imgName = "deck2.gif";
		deckImage = ImageLoader.load(imgName);
		
		cardsSize = new Point(deckImage.getWidth(null), deckImage.getHeight(null));
		tokensSize = new Point(tokensImages[0].getWidth(null), tokensImages[0].getHeight(null));
	}
	
	void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
		infoLabel.setText(String.format("%s is Playing. Score: %d", playerName, playerScore));
	}
}
