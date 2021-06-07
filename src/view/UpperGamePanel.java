package view;

import controller.API;

import java.awt.AWTEvent;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class UpperGamePanel extends JPanel{
	
	@SuppressWarnings("unused") //For whatever reason, eclipse doesn't recognize that this variable is being used.
	private DebugPositioningMode debugPositioning;
	private Boolean debugPositioningMode = false;

	private int playerScore;
	
	private String cardNames[];
	private String cardSuitNames[];
	private String tokenNames[];
	private String playerName;
	
	
	Point screenSize;
	Point center;
	
	private Image cardsImages[];
	private Image tokensImages[];
	private Image deckImage;
	private Image cardsBinImage;
	
	private JButton quitButton;
	private JButton newTurnButton;
	private JButton saveGameButton;
	
	private MouseAdapter mouseEventHandler;
		
	public UpperGamePanel(Point screenSize) {
		super();
		
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setOpaque(false);
		
		this.screenSize = screenSize;
		center = new Point(screenSize.x/2, screenSize.y/2);
		
		buildButtons();
		loadImages();
	}
	
	public UpperGamePanel(Point screenSize, Boolean debugPositioningMode) {
		super();
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setOpaque(false);
		
		this.screenSize = screenSize;
		center = new Point(screenSize.x/2, screenSize.y/2);
		
		buildButtons();
		
		if (debugPositioningMode) {
			this.debugPositioningMode = debugPositioningMode;
			debugPositioning = new DebugPositioningMode();
		}
		
		//loadImages();
	}
	
	private void buildButtons() {
		buildQuitButton();
	}
	
	private void buildQuitButton() {
		quitButton = new JButton("Quit Game");
		quitButton.setToolTipText("Returns to Opening Screen");
		
		add(quitButton);
		
		quitButton.setBounds(screenSize.x - 148, screenSize.y - 45, 148, 45);
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
	
	private class DebugPositioningMode implements ComponentPositionDebuggingInterface, ActionListener {
		private JComponent movingComponent;
		
		public DebugPositioningMode() {
			mouseEventHandler = new ComponentPositionHelper(this);
			
			addMouseListener(mouseEventHandler);
			addMouseMotionListener(mouseEventHandler);
			
			quitButton.addActionListener(this);
			//loadGameButton.addActionListener(this);
		}
		
		public void setSource(Object source) {
			movingComponent = (JComponent)source;
		}
		
		public void actionPerformed(ActionEvent e) {
			setSource(e.getSource());
		}
		
		public void setChildPosition(Point childNewPosition, AWTEvent e) {
			movingComponent.setLocation(childNewPosition.x, childNewPosition.y);				
		}
	}
}
