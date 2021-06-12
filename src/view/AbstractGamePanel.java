package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.API;

//Criar um método que escala uma coordenada x e y baseado em um tamanho de tela (largura x altura) para escalar todos os elementos dessa classe de acordo com o tamanho de tela utilizado.
@SuppressWarnings("serial")
abstract class AbstractGamePanel extends JPanel implements MyMouseListener {
	private JLabel scoreLabel;
	
	Boolean debugPositioningMode = false;
	
	Boolean canDrawCard[];
	
	int playerScore;
	
	String playerName;

	String cardNames[];
	String cardSuitNames[];
	String tokenNames[];
	
	Image deckImage;
	Image cardsBinImage;

	Image cardsImages[];
	Image tokensImages[];
	
	Point screenSize;
	Point center;
	Point buttonsSize;
	Point buttonsLocation;
	Point cardsSize;
	Point tokensSize;
	Point scoreLabelLocation, scoreLabelSize;
	
	Point tokensLocations[];
	Point cardsLocations[];
	
	MyMouseAdapter mouseEventHandler;
	
	public AbstractGamePanel(Point screenSize, String playerName) {
		super();
		
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setOpaque(false);
		
		this.playerName = playerName;					
		
		loadImages();
		
		setSizes(screenSize);
		
		setLocations();
		
		buildScoreLabel();
		
		buildCanDrawCardArray();
		
		mouseEventHandler = new MyMouseAdapter(this);
		addMouseListener(mouseEventHandler);
	}
	
	public AbstractGamePanel(Point screenSize, String playerName, Boolean debugPositioningMode) {
		super();
		
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setOpaque(false);
		
		this.playerName = playerName;
				
		loadImages();
		
		setSizes(screenSize);
		
		setLocations();
		
		buildScoreLabel();
		
		buildCanDrawCardArray();
		
		mouseEventHandler = new MyMouseAdapter(this);
		addMouseListener(mouseEventHandler);
							
		this.debugPositioningMode = debugPositioningMode;
	}
	
	private void setLocations() {
		center = new Point(screenSize.x/2, screenSize.y/2);
		scoreLabelLocation = new Point(screenSize.x - 265, 1);
		
		setCardsLocations();
		setTokensLocations();
	}
	
	private void setCardsLocations() {
		int i;
		
		cardsLocations = new Point[19];
		
		Point cardsBaseLocation = new Point(center.x - cardsSize.x * 5, center.y - cardsSize.y);
		
		for (i = 0; i < 10; i++) {
			cardsLocations[i] = new Point(cardsBaseLocation.x + (cardsSize.x * i), cardsBaseLocation.y);
		}
			
		cardsBaseLocation.x = center.x - cardsSize.x * 4;
		cardsBaseLocation.y = center.y;

		for (i = 0; i < 9; i++) {
			cardsLocations[i + 10] = new Point(cardsBaseLocation.x + (cardsSize.x * i), cardsBaseLocation.y);
		}
	}
	
	private void setTokensLocations() {
		int tokensXDistance = 31;
		
		Point tokensBaseLocation = new Point(center.x + tokensXDistance/2, center.y - cardsSize.y * 2 + cardsSize.y/2 - tokensSize.y/2);
				
		tokensLocations = new Point[6];
		
		//Gray Token (Value: 1)
		tokensLocations[0] = new Point(tokensBaseLocation.x - 3 * (tokensXDistance + tokensSize.x), tokensBaseLocation.y);
		//Purple Token (Value: 5)
		tokensLocations[1] = new Point(tokensBaseLocation.x - 2 * (tokensXDistance + tokensSize.x), tokensBaseLocation.y);
		//Blue Token (Value: 10)
		tokensLocations[2] = new Point(tokensBaseLocation.x - (tokensXDistance + tokensSize.x), tokensBaseLocation.y);
		//Red Token (Value: 20)
		tokensLocations[3] = new Point(tokensBaseLocation.x + (tokensXDistance + tokensSize.x), tokensBaseLocation.y);
		//Green Token (Value: 50)
		tokensLocations[4] = new Point(tokensBaseLocation.x, tokensBaseLocation.y);
		//Black Token (Value: 100)
		tokensLocations[5] = new Point(tokensBaseLocation.x + 2 * (tokensXDistance + tokensSize.x), tokensBaseLocation.y);
	}
	
	private void buildScoreLabel() {
		scoreLabel = new JLabel(String.format("%s is Playing. Score: 0", playerName), SwingConstants.CENTER);
		scoreLabel.setBounds(scoreLabelLocation.x, scoreLabelLocation.y, scoreLabelSize.x, scoreLabelSize.y);
		scoreLabel.setOpaque(true);
		add(scoreLabel);
	}
	
	private void buildCanDrawCardArray() {
		int i;
		canDrawCard = new Boolean[19];
		
		for (i = 0; i < 19; i++) {
			canDrawCard[i] = false;
		}
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
				
		imgName = "deck2.gif";
		deckImage = ImageLoader.load(imgName);
		
		imgName = "deck1.gif";
		cardsBinImage = ImageLoader.load(imgName);
	}
	
	void setSizes(Point screenSize) {
		this.screenSize = screenSize;
		cardsSize = new Point(deckImage.getWidth(null), deckImage.getHeight(null));
		tokensSize = new Point(tokensImages[0].getWidth(null), tokensImages[0].getHeight(null));
		buttonsSize = new Point(148, 45);
		scoreLabelSize = new Point(264, 45);
	}
	
	void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	void repaintPlayerScore(int playerScore) {
		this.playerScore = playerScore;
		scoreLabel.setText(String.format("%s is Playing. Score: %d", playerName, playerScore));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		repaint();
	}
		
	int tokenClicked(Point clickedPoint) {
		if (clickedPoint.x >= tokensLocations[0].x && clickedPoint.x <= tokensLocations[0].x + tokensSize.x) {
			System.out.println("Gray token Clicked !");
			return 0;
		}
		
		else if (clickedPoint.x >= tokensLocations[1].x && clickedPoint.x <= tokensLocations[1].x + tokensSize.x) {
			System.out.println("Purple token Clicked !");
			return 1;
		}
		
		else if (clickedPoint.x >= tokensLocations[2].x && clickedPoint.x <= tokensLocations[2].x + tokensSize.x) {
			System.out.println("Blue token Clicked !");
			return 2;
		}
		
		else if (clickedPoint.x >= tokensLocations[3].x && clickedPoint.x <= tokensLocations[3].x + tokensSize.x) {
			System.out.println("Red token Clicked !");
			return 3;
		}
		
		else if (clickedPoint.x >= tokensLocations[4].x && clickedPoint.x <= tokensLocations[4].x + tokensSize.x) {
			System.out.println("Green token Clicked !");
			return 4;
		}
		
		else if (clickedPoint.x >= tokensLocations[5].x && clickedPoint.x <= tokensLocations[5].x + tokensSize.x) {
			System.out.println("Black token Clicked !");
			return 5;
		}
		
		return -1;
	}
	
	public void setClickedPoint(Point clickedPoint) {

		if (clickedPoint.x >= tokensLocations[0].x && clickedPoint.x <= tokensLocations[5].x + tokensSize.x) {
			if (clickedPoint.y >= tokensLocations[5].y && clickedPoint.y <= tokensLocations[5].y + tokensSize.y) {
				tokenClicked(clickedPoint);				
			}
		} 
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int i, j = 0;
		
		//Draws scoreLabel outline
		g.drawRect(scoreLabelLocation.x - 1, scoreLabelLocation.y - 1, scoreLabelSize.x + 1, scoreLabelSize.y + 1);
		
		for (i = 0; i < 6; i++) {
			
		}
		
		for (i = 0; i < 19; i++) {
			if (canDrawCard[j]) {
				g.drawImage(cardsImages[j], cardsLocations[i].x, cardsLocations[i].y, cardsSize.x, cardsSize.y, null);
			}
			g.drawImage(cardsImages[i], cardsLocations[i].x, cardsLocations[i].y, cardsSize.x, cardsSize.y, null);
		}	
		
		if (debugPositioningMode) {
			g.drawLine(center.x, 0, center.x, screenSize.y);
			g.drawLine(0, center.y, screenSize.x, center.y);
			
			//Outlines cards and tokens position
			
			//Cards position
			g.setColor(Color.green);
			g.drawRect(center.x - cardsSize.x * 5, center.y - cardsSize.y * 2, cardsSize.x * 10, cardsSize.y * 3);
			g.drawLine(center.x - cardsSize.x * 5, center.y - cardsSize.y, center.x + cardsSize.x * 5, center.y - cardsSize.y);
						
			//Tokens position
			g.setColor(Color.red);
			g.drawRect((cardsLocations[0].x + cardsSize.x), center.y - cardsSize.y * 2, cardsSize.x * 8, cardsSize.y);
			g.drawLine((cardsLocations[0].x + cardsSize.x), center.y - cardsSize.y * 2 + cardsSize.y/2, (cardsLocations[0].x + cardsSize.x) + cardsSize.x * 8 , center.y - cardsSize.y * 2 + cardsSize.y/2);		
		}
	}

}
