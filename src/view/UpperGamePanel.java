package view;

import java.awt.Graphics;
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
	@SuppressWarnings("unused") //For whatever reason, eclipse doesn't recognize that this variable is being used.
	private Boolean debugPositioningMode = false;
	
	private Point deckLocation;
	private Point cardsBinLocation;
		
	private JButton quitButton;
	private JButton newTurnButton;
	private JButton saveGameButton;
	
	public UpperGamePanel(Point screenSize, String playerName) {
		super(screenSize, playerName);
		
		setLocations();
		buildButtons();
	}
	
	public UpperGamePanel(Point screenSize, String playerName, Boolean debugPositioningMode) {
		super(screenSize, playerName, debugPositioningMode);
		
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
		
		deckLocation = new Point(cardsLocations[0].x, cardsLocations[0].y - cardsSize.y);
		cardsBinLocation = new Point(cardsLocations[9].x, deckLocation.y);
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
		
	private Boolean deckClicked() {
		System.out.println("Deck Clicked !");
		return true;
	}
	
	private Boolean cardsBinClicked() {
		System.out.println("Cards bin Clicked !");
		return true;
	}
	
	public void setClickedPoint(Point clickedPoint) {
		super.setClickedPoint(clickedPoint);
		
		if (clickedPoint.y >= deckLocation.y && clickedPoint.y <= deckLocation.y + cardsSize.y) {
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
		int i;
		
		//Draw Deck and cards bin
		g.drawImage(deckImage, deckLocation.x, deckLocation.y, cardsSize.x, cardsSize.y, null);
		g.drawImage(cardsBinImage, cardsBinLocation.x, cardsBinLocation.y, cardsSize.x, cardsSize.y, null);
		
		//Draw Tokens
		for (i = 0; i < 6; i++) {
			g.drawImage(tokensImages[i], tokensLocations[i].x, tokensLocations[i].y, tokensSize.x, tokensSize.y, null);
		}
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
