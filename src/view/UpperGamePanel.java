package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class UpperGamePanel extends AbstractGamePanel implements MyMouseListener {
	
	@SuppressWarnings("unused") //For whatever reason, eclipse doesn't recognize that this variable is being used.
	private DebugPositioningMode debugPositioning;
	private Boolean debugPositioningMode = false;
	
	private Image cardsBinImage;
	
	private Point deckLocation;
	private Point cardsBinLocation;
	private Point grayTokenLocation, purpleTokenLocation, blueTokenLocation, redTokenLocation, greenTokenLocation, blackTokenLocation;
	
	private MyMouseAdapter mouseEventHandler;
	
	private JButton quitButton;
	private JButton newTurnButton;
	private JButton saveGameButton;
	
	public UpperGamePanel(Point screenSize, String playerName) {
		super(screenSize, playerName);
		
		mouseEventHandler = new MyMouseAdapter(this);
		addMouseListener(mouseEventHandler);
		
		cardsBinImage = ImageLoader.load("deck1.gif");
		
		setLocations();
		buildButtons();
		
	}
	
	public UpperGamePanel(Point screenSize, String playerName, Boolean debugPositioningMode) {
		super(screenSize, playerName, debugPositioningMode);
				
		mouseEventHandler = new MyMouseAdapter(this);
		addMouseListener(mouseEventHandler);
		
		cardsBinImage = ImageLoader.load("deck1.gif");

		setLocations();
		buildButtons();
		
		if (debugPositioningMode) {
			this.debugPositioningMode = debugPositioningMode;
			debugPositioning = new DebugPositioningMode();
		}
		
	}
	
	private void setLocations() {
		//Uses quitButton as reference
		buttonsLocation = new Point(screenSize.x - buttonsSize.x * 3, screenSize.y - buttonsSize.y);
		
		deckLocation = new Point(683 - cardsSize.x, 105);
		cardsBinLocation = new Point(517, 105);
		
		greenTokenLocation = new Point(center.x + 34 * 2 + tokensSize.x - 17, 376);
		grayTokenLocation = new Point(center.x - 34 * 3 - tokensSize.x * 3 + 17, 376);
		purpleTokenLocation = new Point(center.x - 34 * 2 - tokensSize.x * 2 + 17, 376);
		blueTokenLocation = new Point(center.x - 34 - tokensSize.x + 17, 376);
		redTokenLocation = new Point( center.x + 34 - 17, 376);
		blackTokenLocation = new Point(center.x + 34 * 3 + tokensSize.x * 2 - 17, 376);
	}
	
	private void buildButtons() {
		buildQuitButton();
		buildSaveGameButton();
		buildNewTurnButton();
	}
	
	private void buildNewTurnButton() {
		newTurnButton = new JButton("New Turn");
		newTurnButton.setToolTipText("Starts a new turn");
		
		add(newTurnButton);
		
		newTurnButton.setBounds(buttonsLocation.x + buttonsSize.x * 2, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
	
	private void buildSaveGameButton() {
		
		saveGameButton = new JButton("Save");
		saveGameButton.setToolTipText("Saves this game state");
		
		add(saveGameButton);
		
		saveGameButton.setBounds(buttonsLocation.x + buttonsSize.x, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
		
	private void buildQuitButton() {
		quitButton = new JButton("Quit");
		quitButton.setToolTipText("Returns to Opening Screen");
		
		add(quitButton);
		
		quitButton.setBounds(buttonsLocation.x, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
	
	private int tokenClicked(Point clickedPoint) {
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
	
	private Boolean deckClicked() {
		System.out.println("Deck Clicked !");
		return true;
	}
	
	private Boolean cardsBinClicked() {
		System.out.println("Cards bin Clicked !");
		return true;
	}
	
	public void setClickedPoint(Point clickedPoint) {
		if ( (clickedPoint.x >= grayTokenLocation.x && clickedPoint.x <= blackTokenLocation.x + tokensSize.x) && (clickedPoint.y >= blackTokenLocation.y && clickedPoint.y <= blackTokenLocation.y + tokensSize.y) ) {
			tokenClicked(clickedPoint);
		}
		
		else if (clickedPoint.y >= deckLocation.y && clickedPoint.y <= deckLocation.y + cardsSize.y) {
			if (clickedPoint.x >= deckLocation.x && clickedPoint.x <= deckLocation.x + cardsSize.x) {
				deckClicked();	
			}
			
			else if (clickedPoint.x >= cardsBinLocation.x && clickedPoint.x <= cardsBinLocation.x + cardsSize.x) {
				cardsBinClicked();
			}
		}
			
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (debugPositioningMode) {
			g.drawLine(center.x, 0, center.x, screenSize.y);
			g.drawLine(0, center.y, screenSize.x, center.y);
		}
		
		//Draw Deck and cards bin
		g.drawImage(deckImage, deckLocation.x, deckLocation.y, cardsSize.x, cardsSize.y, null);
		g.drawImage(cardsBinImage, cardsBinLocation.x, cardsBinLocation.y, cardsSize.x, cardsSize.y, null);
		
		//Draw six tokens types
		
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
	}
	
	private class DebugPositioningMode implements ComponentPositionDebuggingInterface, ActionListener {
		private MouseAdapter mouseEventHandler;
		
		private JComponent movingComponent;
		//Button created with the exact size of each image to be used as a reference for image positioning
		private JButton debugPositionReferenceButton;
		
		private DebugPositioningMode() {
			mouseEventHandler = new ComponentPositionHelper(this);
			
			buildDebugPositionReferenceButton();
			
			addMouseListener(mouseEventHandler);
			addMouseMotionListener(mouseEventHandler);
			
			quitButton.addActionListener(this);
			saveGameButton.addActionListener(this);
			newTurnButton.addActionListener(this);
			
			debugPositionReferenceButton.addActionListener(this);
		}
		
		public void setSource(Object source) {
			movingComponent = (JComponent)source;
		}
		
		public void actionPerformed(ActionEvent e) {
			setSource(e.getSource());
		}
		
		public void setChildPosition(Point childNewPosition) {
			movingComponent.setLocation(childNewPosition.x, childNewPosition.y);			
		}
		
		private void buildDebugPositionReferenceButton() {
			debugPositionReferenceButton = new JButton("Reference");		
			UpperGamePanel.this.add(debugPositionReferenceButton);
			
			debugPositionReferenceButton.setBounds(screenSize.x - 54, 0, 54, 54);
		}
	}
}
