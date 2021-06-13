package view;

import java.util.Hashtable;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.API;

//Criar um método que escala uma coordenada x e y baseado em um tamanho de tela (largura x altura) para escalar todos os elementos dessa classe de acordo com o tamanho de tela utilizado.
@SuppressWarnings("serial")
public abstract class AbstractGamePanel extends JPanel implements MyMouseListener {
	private JLabel scoreLabel;
	
	static String cardNames[];
	static String cardSuitNames[];
	static String tokenNames[];
	
	static Hashtable<String, Image> cardNameImageMap;
	
	static Image deckImage;
	static Image cardsBinImage;

	static Image tokensImages[];
	
	static int playersQuantity = 1;
	
	Boolean debugPositioningMode = false;
		
	int playerScore;
	int cardsQuantity;
	int fontSize;
	
	String playerName;
	String cardsInHand[];
	
	Point screenSize;
	Point center;
	Point buttonsSize;
	Point buttonsLocation;
	Point cardsSize;
	Point tokensSize;
	Point scoreLabelLocation, scoreLabelSize;
	
	Point tokensLocations[];
	Point cardsLocations[];
	
	Font myFont;
	
	MyMouseAdapter mouseEventHandler;
	
	public AbstractGamePanel(Point screenSize, String playerName) {
		super();
		
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setOpaque(false);
		
		playerScore = 0;
		cardsQuantity = 0;
		
		this.playerName = playerName;					
		
		cardsInHand = new String[30];
		
		loadImages();
		
		setSizes(screenSize);
		
		setLocations();
		
		buildScoreLabel();
		
		setMyFont();
		
		mouseEventHandler = new MyMouseAdapter(this);
		addMouseListener(mouseEventHandler);
	}
	
	public AbstractGamePanel(Point screenSize, String playerName, Boolean debugPositioningMode) {
		super();
		
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setOpaque(false);
		
		playerScore = 0;
		cardsQuantity = 0;
		
		this.playerName = playerName;
		
		cardsInHand = new String[30];
		
		loadImages();
		
		setSizes(screenSize);
		
		setLocations();
		
		buildScoreLabel();
		
		setMyFont();
		
		mouseEventHandler = new MyMouseAdapter(this);
		addMouseListener(mouseEventHandler);
							
		this.debugPositioningMode = debugPositioningMode;
	}
	
	private void setLocations() {
		center = new Point(screenSize.x/2, screenSize.y/2);
		
		scoreLabelLocation = new Point(screenSize.x - ResizingTool.resizeX(screenSize.x, 265), 1);
		
		if (this instanceof DownerGamePanel) {
			scoreLabelLocation = new Point(screenSize.x - ResizingTool.resizeX(screenSize.x, 265) * playersQuantity/2 - (ResizingTool.resizeX(screenSize.x, 21)), 1);
		}
				
		setCardsLocations();
		setTokensLocations();
	}
	
	private void setCardsLocations() {
		int i;
		
		cardsLocations = new Point[30];
		
		Point cardsBaseLocation = new Point(center.x - cardsSize.x * 5, center.y - cardsSize.y);
		
		for (i = 0; i < 10; i++) {
			cardsLocations[i] = new Point(cardsBaseLocation.x + (cardsSize.x * i), cardsBaseLocation.y);
		}
		
		cardsBaseLocation.x = center.x - cardsSize.x * 4;
		cardsBaseLocation.y = center.y;

		for (i = 0; i < 9; i++) {
			cardsLocations[i + 10] = new Point(cardsBaseLocation.x + (cardsSize.x * i), cardsBaseLocation.y);
		}
		
		cardsBaseLocation.x = center.x - cardsSize.x * 5;
		cardsBaseLocation.y = center.y + cardsSize.y;
		
		for (i = 0; i < 11; i++) {
			cardsLocations[i + 19] = new Point(cardsBaseLocation.x + (cardsSize.x * i), cardsBaseLocation.y);
		}
	}
	
	private void setTokensLocations() {
		int tokensXDistance = ResizingTool.resizeX(screenSize.x, 31);
		
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
	
	private void setMyFont() {
		myFont = new Font("Dialog", Font.BOLD, fontSize);
	}
	
	private void buildScoreLabel() {
		scoreLabel = new JLabel(String.format("%s.: Score: 0", playerName), SwingConstants.CENTER);
		scoreLabel.setBounds(scoreLabelLocation.x, scoreLabelLocation.y, scoreLabelSize.x, scoreLabelSize.y);
		scoreLabel.setOpaque(true);
		add(scoreLabel);
	}

	public static void setPlayersQuantity(int value) {
		playersQuantity = value;
	}
	
	void loadImages() {
		int i = 0;
		
		Image cardImage;
		
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
		
		cardNameImageMap = new Hashtable <String, Image>();
		
		for (String cardName : cardNames) {
			
			for (String suitName : cardSuitNames) {
				imgName = cardName + "_" + suitName;
				cardImage = ImageLoader.load(imgName + ".gif");
				
				cardNameImageMap.put(imgName, cardImage);
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
		int resized45;
		this.screenSize = screenSize;
		
		cardsSize = new Point(ResizingTool.resizeX(screenSize.x, deckImage.getWidth(null)), ResizingTool.resizeY(screenSize.y, deckImage.getHeight(null)));
		tokensSize = new Point(ResizingTool.resizeX(screenSize.x, tokensImages[0].getWidth(null)), ResizingTool.resizeY(screenSize.y, tokensImages[0].getHeight(null)));
		
		resized45 = ResizingTool.resizeY(screenSize.y, 45);
		
		buttonsSize = new Point(ResizingTool.resizeX(screenSize.x, 148), resized45);
		scoreLabelSize = new Point(ResizingTool.resizeX(screenSize.x, 264) + (ResizingTool.resizeX(screenSize.x, 21)), resized45);
			
		if (this instanceof DownerGamePanel) {
			buttonsSize.x = buttonsSize.x * playersQuantity/2;
			scoreLabelSize.x = scoreLabelSize.x * playersQuantity/2;
		}
		
		fontSize = 12;
	}
	
	void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	void repaintPlayerScore(int playerScore) {
		this.playerScore = playerScore;
		scoreLabel.setText(String.format("%s.: Score: %d", playerName, playerScore));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		repaint();
	}
		
	int tokenClicked(Point clickedPoint) {
		//Substituir por funcoes do controller ao invez dos valores de retorno ?
		if (clickedPoint.x >= tokensLocations[0].x && clickedPoint.x <= tokensLocations[0].x + tokensSize.x) {
			return 0;
		}
		
		else if (clickedPoint.x >= tokensLocations[1].x && clickedPoint.x <= tokensLocations[1].x + tokensSize.x) {
			return 1;
		}
		
		else if (clickedPoint.x >= tokensLocations[2].x && clickedPoint.x <= tokensLocations[2].x + tokensSize.x) {
			return 2;
		}
		
		else if (clickedPoint.x >= tokensLocations[3].x && clickedPoint.x <= tokensLocations[3].x + tokensSize.x) {
			return 3;
		}
		
		else if (clickedPoint.x >= tokensLocations[4].x && clickedPoint.x <= tokensLocations[4].x + tokensSize.x) {
			return 4;
		}
		
		else if (clickedPoint.x >= tokensLocations[5].x && clickedPoint.x <= tokensLocations[5].x + tokensSize.x) {
			return 5;
		}
		
		return -1;
	}
	
	void setCardInHand(String cardName) {
		cardsInHand[cardsQuantity] = cardName;
		cardsQuantity++;
		repaint();
		
	}
	
	void resetCardsInHandArray() {
		int i;
		
		for(i = 0; i < cardsInHand.length; i++) {
			cardsInHand[i] = null;
		}
		
		cardsQuantity = 0;
		repaint();
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
		
		int i;
		
		Image cardImage;
		
		//Draws scoreLabel outline
		g.drawRect(scoreLabelLocation.x - 1, scoreLabelLocation.y - 1, scoreLabelSize.x + 1, scoreLabelSize.y + 1);
		
		for (i = 0; i < cardsQuantity; i++) {
			if (cardsInHand[i] != null) {
				cardImage = cardNameImageMap.get(cardsInHand[i]);
				g.drawImage(cardImage, cardsLocations[i].x, cardsLocations[i].y, cardsSize.x, cardsSize.y, null);
			}
		}
		
		if (debugPositioningMode) {
			
			//Draw middle lines for reference
			g.drawLine(center.x, 0, center.x, screenSize.y);
			g.drawLine(0, center.y, screenSize.x, center.y);
			
			//Outlines cards and tokens position
			
			//Cards position
			g.setColor(Color.green);
			g.drawRect(center.x - cardsSize.x * 5, center.y - cardsSize.y * 2, cardsSize.x * 10, cardsSize.y * 4);
			g.drawLine(center.x - cardsSize.x * 5, center.y - cardsSize.y, center.x + cardsSize.x * 5, center.y - cardsSize.y);
			
			//Tokens position
			g.setColor(Color.red);
			g.drawRect((cardsLocations[0].x + cardsSize.x), center.y - cardsSize.y * 2, cardsSize.x * 8, cardsSize.y);
			g.drawLine((cardsLocations[0].x + cardsSize.x), center.y - cardsSize.y * 2 + cardsSize.y/2, (cardsLocations[0].x + cardsSize.x) + cardsSize.x * 8 , center.y - cardsSize.y * 2 + cardsSize.y/2);		
		
			g.setColor(Color.black);
		}
	}

}