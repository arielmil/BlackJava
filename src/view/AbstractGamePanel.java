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
	Point grayTokenLocation, purpleTokenLocation, blueTokenLocation;
	Point redTokenLocation, greenTokenLocation, blackTokenLocation;
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
		
		greenTokenLocation = new Point(tokensBaseLocation.x, tokensBaseLocation.y);
		grayTokenLocation = new Point(tokensBaseLocation.x - 3 * (tokensXDistance + tokensSize.x), tokensBaseLocation.y);
		purpleTokenLocation = new Point(tokensBaseLocation.x - 2 * (tokensXDistance + tokensSize.x), tokensBaseLocation.y);
		blueTokenLocation = new Point(tokensBaseLocation.x - (tokensXDistance + tokensSize.x), tokensBaseLocation.y);
		redTokenLocation = new Point(tokensBaseLocation.x + (tokensXDistance + tokensSize.x), tokensBaseLocation.y);
		blackTokenLocation = new Point(tokensBaseLocation.x + 2 * (tokensXDistance + tokensSize.x), tokensBaseLocation.y);
	}
	
	private void buildScoreLabel() {
		scoreLabel = new JLabel(String.format("%s is Playing. Score: 0", playerName), SwingConstants.CENTER);
		scoreLabel.setBounds(scoreLabelLocation.x, scoreLabelLocation.y, scoreLabelSize.x, scoreLabelSize.y);
		scoreLabel.setOpaque(true);
		add(scoreLabel);
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
		if (clickedPoint.x >= grayTokenLocation.x && clickedPoint.x <= grayTokenLocation.x + tokensSize.x) {
			System.out.println("Gray token Clicked !");
			return 0;
		}
		
		else if (clickedPoint.x >= purpleTokenLocation.x && clickedPoint.x <= purpleTokenLocation.x + tokensSize.x) {
			System.out.println("Purple token Clicked !");
			return 1;
		}
		
		else if (clickedPoint.x >= blueTokenLocation.x && clickedPoint.x <= blueTokenLocation.x + tokensSize.x) {
			System.out.println("Blue token Clicked !");
			return 2;
		}
		
		else if (clickedPoint.x >= redTokenLocation.x && clickedPoint.x <= redTokenLocation.x + tokensSize.x) {
			System.out.println("Red token Clicked !");
			return 3;
		}
		
		else if (clickedPoint.x >= greenTokenLocation.x && clickedPoint.x <= greenTokenLocation.x + tokensSize.x) {
			System.out.println("Green token Clicked !");
			return 4;
		}
		
		else if (clickedPoint.x >= blackTokenLocation.x && clickedPoint.x <= blackTokenLocation.x + tokensSize.x) {
			System.out.println("Black token Clicked !");
			return 5;
		}
		
		return -1;
	}
	
	int cardClicked(int clickedX, cardPosition pos) {
		
		if (clickedX > cardsLocations[0].x && clickedX <= cardsLocations[1].x) {
			switch(pos) {
				case UP: System.out.println("Card 0 Clicked !"); return 0;
				case DOWN: return -1;
			}
		}
		
		else if (clickedX > cardsLocations[1].x && clickedX <= cardsLocations[2].x) {
			switch(pos) {
				case UP: System.out.println("Card 1 Clicked !"); return 1;
				case DOWN: System.out.println("Card 10 Clicked !"); return 10;
			}
		}
		
		else if (clickedX > cardsLocations[2].x && clickedX <= cardsLocations[3].x) {
			switch(pos) {
				case UP: System.out.println("Card 2 Clicked !"); return 2;
				case DOWN: System.out.println("Card 11 Clicked !"); return 11;
			}
		}
		
		else if (clickedX > cardsLocations[3].x && clickedX <= cardsLocations[4].x) {
			switch(pos) {
				case UP: System.out.println("Card 3 Clicked !"); return 3;
				case DOWN: System.out.println("Card 12 Clicked !"); return 12;
			}
		}
		
		else if (clickedX > cardsLocations[4].x && clickedX <= cardsLocations[5].x) {
			switch(pos) {
				case UP: System.out.println("Card 4 Clicked !"); return 4;
				case DOWN: System.out.println("Card 13 Clicked !"); return 13;
			}
		}
		
		else if (clickedX > cardsLocations[5].x && clickedX <= cardsLocations[6].x) {
			switch(pos) {
				case UP: System.out.println("Card 5 Clicked !"); return 5;
				case DOWN: System.out.println("Card 14 Clicked !"); return 14;
			}
		}
		
		else if (clickedX > cardsLocations[6].x && clickedX <= cardsLocations[7].x) {
			switch(pos) {
				case UP: System.out.println("Card 6 Clicked !"); return 6;
				case DOWN: System.out.println("Card 15 Clicked !"); return 15;
			}
		}
		
		else if (clickedX > cardsLocations[7].x && clickedX <= cardsLocations[8].x) {
			switch(pos) {
				case UP: System.out.println("Card 7 Clicked !"); return 7;
				case DOWN: System.out.println("Card 16 Clicked !"); return 16;
			}
		}
		
		else if (clickedX > cardsLocations[8].x && clickedX <= cardsLocations[9].x) {
			switch(pos) {
				case UP: System.out.println("Card 8 Clicked !"); return 8;
				case DOWN: System.out.println("Card 17 Clicked !"); return 17;
			}
		}
		
		else {
			switch(pos) {
				case UP: System.out.println("Card 9 Clicked !"); return 9;
				case DOWN: System.out.println("Card 18 Clicked !"); return 18;
			}
		}
		
		// For some reason, to avoid compiling errors, Javac forced a return statement here
		return -1;
	}
		
	public void setClickedPoint(Point clickedPoint) {

		if ( (clickedPoint.x >= grayTokenLocation.x && clickedPoint.x <= blackTokenLocation.x + tokensSize.x) && (clickedPoint.y >= blackTokenLocation.y && clickedPoint.y <= blackTokenLocation.y + tokensSize.y) ) {
			tokenClicked(clickedPoint);
		} 
		
		else if ( (clickedPoint.x >= cardsLocations[0].x && clickedPoint.x <= cardsLocations[9].x + cardsSize.x) && (clickedPoint.y >= cardsLocations[0].y && clickedPoint.y <= cardsLocations[18].y + cardsSize.y) ) {

			if (clickedPoint.y >= cardsLocations[0].y && clickedPoint.y < cardsLocations[18].y) {
				cardClicked(clickedPoint.x, cardPosition.UP);
			}
			
			else {
				cardClicked(clickedPoint.x, cardPosition.DOWN);
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int i;
		
		//Draws scoreLabel outline
		g.drawRect(scoreLabelLocation.x - 1, scoreLabelLocation.y - 1, scoreLabelSize.x + 1, scoreLabelSize.y + 1);
		
		//Green Token (Value: 50)
		g.drawImage(tokensImages[3], greenTokenLocation.x, greenTokenLocation.y, tokensSize.x, tokensSize.y, null);
		//Gray Token (Value: 1)
		g.drawImage(tokensImages[0], grayTokenLocation.x, grayTokenLocation.y, tokensSize.x, tokensSize.y, null);
		//Purple Token (Value: 5)
		g.drawImage(tokensImages[4], purpleTokenLocation.x, purpleTokenLocation.y, tokensSize.x, tokensSize.y, null);
		//Blue Token (Value: 10)
		g.drawImage(tokensImages[2], blueTokenLocation.x, blueTokenLocation.y, tokensSize.x, tokensSize.y, null);
		//Red Token (Value: 20)
		g.drawImage(tokensImages[1], redTokenLocation.x, redTokenLocation.y, tokensSize.x, tokensSize.y, null);
		//Black Token (Value: 100)
		g.drawImage(tokensImages[5], blackTokenLocation.x, blackTokenLocation.y, tokensSize.x, tokensSize.y, null);
		
		for (i = 0; i < 19; i++) {
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
	
	int ResizingCoodernate_X (int ScreenSize_X, int ObjectLocation_X)
	{
		ObjectLocation_X = ObjectLocation_X * (ScreenSize_X/1200);
		return ObjectLocation_X;
	}
	
	int ResizingCoodernate_Y (int ScreenSize_Y , int ObjectLocation_Y)
	{
		ObjectLocation_Y = ObjectLocation_Y * (ScreenSize_Y/720);
		return ObjectLocation_Y;
	}
	
	Point PointResizing (int ScreenSize_X, int ScreenSize_Y, Point object)
	{
		object.x = object.x * (ScreenSize_X/1200);
		object.y = object.y * (ScreenSize_Y/700);
		
		return object;
	}

	private enum cardPosition {
		UP,
		DOWN
	}
}
