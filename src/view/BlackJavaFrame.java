// Ariel Mileguir
// Pedro Gabriel 

package view;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BlackJavaFrame extends JFrame {
	//Stores the number of the currently playing player
	private int playerIsPlaying = 0;
	
	private int playersQuantity;
	private String playerNames[];
	private int playersBalance[];
	
	private Container contentPane;
	
	private Insets frameBorders;
	
	private OpeningScreenPanel openingScreenPanel;
	private UpperGamePanel dealerPanel;
	private DownerGamePanel playerPanels[];
	
	private Point screenSize, openingScreenPanelSize, dealerPanelSize, playerPanelsSize;
	
	private TablePanel openingScreenPanelBackground, dealerPanelBackground;
	private TablePanel playerPanelsBackgrounds[];
	
	public BlackJavaFrame() {
		super("BlackJava");
		screenSize = new Point(1200, 700);
				
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frameBorders = getInsets();
		
		contentPane = getContentPane();
		contentPane.setLayout(null);
		
		openingScreenPanelSize = new Point(screenSize.x, screenSize.y - (frameBorders.top + frameBorders.bottom));
		
		startOpeningPanel();
	}
	
	private void startOpeningPanel() {
		openingScreenPanel = new OpeningScreenPanel(openingScreenPanelSize);
		openingScreenPanelBackground = new TablePanel(openingScreenPanel);
		openingScreenPanelBackground.setVisible(true);
		contentPane.add(openingScreenPanelBackground);
		repaint();
	}
	
	private void startGamePanels(int playersQuantity, int playersBalance[]) {
		this.playersQuantity = playersQuantity;
		this.playersBalance = playersBalance;
		startDealerPanel();
		startPlayerPanels();
		repaint();
	}
	
	private void startDealerPanel() {
		dealerPanelSize = new Point(openingScreenPanelSize.x, openingScreenPanelSize.y / 2);
		dealerPanel = new UpperGamePanel(dealerPanelSize);
		dealerPanelBackground = new TablePanel(dealerPanel);
		dealerPanelBackground.setVisible(false);
		contentPane.add(dealerPanelBackground);
	}
	
	private void startPlayerPanels() {
		int i;
		
		playerPanels = new DownerGamePanel[playersQuantity];
		playerPanelsSize = new Point(openingScreenPanelSize.x / playersQuantity, 700/2);
		Point basePlayerPanelsScreenLocation = new Point(0, screenSize.y/2 - (frameBorders.top + frameBorders.bottom));
		
		playerPanelsBackgrounds = new TablePanel[playersQuantity];
		DownerGamePanel.setPlayersQuantity(playersQuantity);
		
		for (i = 0; i < playersQuantity; i++) {
			playerPanels[i] = new DownerGamePanel(basePlayerPanelsScreenLocation, playerPanelsSize, playerNames[i], playersBalance[i], true);
			playerPanelsBackgrounds[i] = new TablePanel(playerPanels[i]);
			playerPanelsBackgrounds[i].setVisible(true);
			contentPane.add(playerPanelsBackgrounds[i]);
			basePlayerPanelsScreenLocation.x = basePlayerPanelsScreenLocation.x + playerPanelsSize.x;
		}
	}
	
	private void setPlayerNames(String playerNames[]) {
		
		this.playerNames = new String[playersQuantity];
		this.playerNames = playerNames;
	}
	
	private void setPlayersQuantity(int playersQuantity) {
		this.playersQuantity = playersQuantity;
	}
	
	public void startGame(int playersQuantity, String playerNames[], int[] playersBalance) {
		setPlayersQuantity(playersQuantity);
		setPlayerNames(playerNames);
		startGamePanels(playersQuantity, playersBalance);
		
		openingScreenPanelBackground.setVisible(false);
		dealerPanelBackground.setVisible(true);
		
		for (TablePanel tablePanel: playerPanelsBackgrounds) {
			tablePanel.setVisible(true);
		}
	}
	
	public void quitGame() {
		for (TablePanel tablePanel: playerPanelsBackgrounds) {
			tablePanel.setVisible(false);
		}
		dealerPanelBackground.setVisible(false);
		
		openingScreenPanelBackground.setVisible(true);
	}
	
	public void setPlayerScore(int score, int playerNumber, int handNumber) {
		if (playerNumber == 0) {
			dealerPanel.repaintPlayerScore(score);
		}
		
		else {
			playerPanels[playerNumber].repaintPlayerScore(score, handNumber);
		}
	}
		
	public void dealCard(int playerNumber, String cardName) {
		if (playerNumber == 0) {
			dealerPanel.setCardInHand(cardName);
		}
		
		else {
			playerPanels[playerNumber].setCardInHand(cardName);
		}
	}
	
	public void endTurn() {
		dealerPanel.resetCardsInHandArray();
		
		for (DownerGamePanel playerPanel : playerPanels) {
			playerPanel.resetCardsInHandArray();
		}
		
		playerPanels[playerIsPlaying].showButtonsAndBetLabel();
	}
	
	public void setBalance(int playerNumber, int balance) {
		playerPanels[playerNumber].setBalance(balance);
	}
	
	public void setBet(int playerNumber, int bet) {
		playerPanels[playerNumber].setBetValue(bet);
	}
	
	public void playerStand() {
		playerPanels[playerIsPlaying].hideButtonsAndBetLabel();
		playerIsPlaying++;
		playerPanels[playerIsPlaying].showButtonsAndBetLabel();
		
		if (playerIsPlaying == playersQuantity) {
			playerIsPlaying = 0;
		}
	}
}