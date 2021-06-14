package view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DownerGamePanel extends AbstractGamePanel	{

	@SuppressWarnings("unused") //For whatever reason, eclipse doesn't recognize that this variable is being used.
	private DebugPositioningMode debugPositioning;
		
	private Boolean scoreLabelDoubleSplitIsVisible = false;
	
	private int betValue;
	private int balance = 500;
	private int playerSplitScore;
	private int labelsWidth;
	
	private JLabel scoreLabelDoubleSplit;
	private JLabel betLabel;
	private JLabel balanceLabel;
	
	private JButton standButton;
	private JButton doubleButton;
	private JButton splitButton;
	private JButton insuranceButton;
	private JButton surrenderButton;
	private JButton hitButton;
	
	public DownerGamePanel(Point locationOnFrame, Point screenSize, String playerName) {
		super(locationOnFrame, screenSize, playerName);
		
		setLocations();
		
		buildButtons();
		
		buildLabels();
	}	

	public DownerGamePanel(Point locationOnFrame, Point screenSize, String playerName, Boolean debugPositioningMode) {
		super(locationOnFrame, screenSize, playerName, debugPositioningMode);
		
		setLocations();
		
		buildButtons();
		
		buildLabels();
		
		if (debugPositioningMode) {
			debugPositioning = new DebugPositioningMode();
		}
	}
	

	private void setLocations() {
		//Uses surrenderButton as reference
		buttonsLocation = new Point(screenSize.x - buttonsSize.x * 4, screenSize.y - buttonsSize.y);
	}
	
	
	private void buildLabels() {
		
		labelsWidth = (int)(scoreLabelSize.x * 0.75);
		
		buildBetLabel();
		buildBalanceLabel();
		buildScoreLabelDoubleSplit();
	}
	
	
	private void buildScoreLabelDoubleSplit() {
		scoreLabelDoubleSplit = new JLabel(String.format("%s.: Score: 0", playerName), SwingConstants.CENTER);
		scoreLabelDoubleSplit.setBounds(scoreLabelLocation.x, scoreLabelLocation.y + scoreLabelSize.y + 1, scoreLabelSize.x, scoreLabelSize.y);
		scoreLabelDoubleSplit.setOpaque(true);
		scoreLabelDoubleSplit.setVisible(false);
		add(scoreLabelDoubleSplit);
	}
	
	private void buildBalanceLabel() {
		balanceLabel = new JLabel(String.format("Bal: %d", balance), SwingConstants.CENTER);
		balanceLabel.setFont(myFont);
		balanceLabel.setBounds(1, 1, labelsWidth, scoreLabelSize.y);
		balanceLabel.setOpaque(true);
		add(balanceLabel);
	}
	

	private void buildBetLabel() {
		betLabel = new JLabel(String.format("Bet: %d", betValue), SwingConstants.CENTER);
		betLabel.setFont(myFont);
		betLabel.setBounds(1, scoreLabelSize.y + 2, labelsWidth, scoreLabelSize.y);
		betLabel.setOpaque(true);
		add(betLabel);
	}
	

	private void buildButtons() {
		buildStandButton();
		buildInsuranceButton();
		buildSplitButton();
		buildDoubleButton();
		buildSurrenderButton();
		buildHitButton();
	}
	

	private void buildStandButton() {
		standButton = new JButton("Std");
		standButton.setFont(myFont);
		standButton.setToolTipText("End turn");
		standButton.setVisible(true);
		
		add(standButton);
		
		standButton.setBounds(buttonsLocation.x + buttonsSize.x, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
	

	private void buildInsuranceButton() {
		insuranceButton = new JButton("Ins");
		insuranceButton.setFont(myFont);
		insuranceButton.setToolTipText("Player get half his bet value if dealer's second card is a ten valued card (10, Jack, Queen or King)");
		insuranceButton.setVisible(false);
		
		add(insuranceButton);
		
		insuranceButton.setBounds(buttonsLocation.x + buttonsSize.x * 3, buttonsLocation.y - buttonsSize.y, buttonsSize.x, buttonsSize.y);
	}
	
	private void buildHitButton() {
		hitButton = new JButton("Hit");
		hitButton.setFont(myFont);
		hitButton.setToolTipText("Player will hit on his Second Hand");
		hitButton.setVisible(false);
		
		add(hitButton);
		
		hitButton.setBounds(buttonsLocation.x + buttonsSize.x * 3, buttonsLocation.y - buttonsSize.y, buttonsSize.x, buttonsSize.y);
	}
	

	private void buildSurrenderButton() {
		surrenderButton = new JButton("Sur");
		surrenderButton.setFont(myFont);
		surrenderButton.setToolTipText("Player get half his bet value back and finish his turn");
		surrenderButton.setVisible(true);
		
		add(surrenderButton);
		
		surrenderButton.setBounds(buttonsLocation.x, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
	

	private void buildSplitButton() {
		splitButton = new JButton("Spt");
		splitButton.setFont(myFont);
		splitButton.setToolTipText("Player get another hand and doubles his bet value (player needs to have at least double of the amount of tokens available to bet)");
		splitButton.setVisible(true);

		add(splitButton);
		
		splitButton.setBounds(buttonsLocation.x + buttonsSize.x * 2, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
	

	private void buildDoubleButton() {
		doubleButton = new JButton("Dbl");
		doubleButton.setFont(myFont);
		doubleButton.setToolTipText("Player Doubles his bet value (player needs to have at least double of the amount of tokens available to bet)");
		doubleButton.setVisible(true);

		add(doubleButton);
		
		doubleButton.setBounds(buttonsLocation.x + buttonsSize.x * 3, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
	

	private void repaintBalanceLabel() {
		balanceLabel.setText(String.format("Bal: %d ", balance));
		balanceLabel.setAlignmentX(SwingConstants.CENTER);
		repaint();
	}
	

	private void repaintBetLabel() {
		betLabel.setText(String.format("Bet: %d", betValue));
		betLabel.setAlignmentX(SwingConstants.CENTER);
		repaint();
	}
	
	void repaintPlayerScore(int playerScore, int handNumber) {
		if (handNumber == 1) {
			super.repaintPlayerScore(playerScore);
		}
		
		else {
			playerSplitScore = playerScore;
			scoreLabelDoubleSplit.setText(String.format("%s.: Score: %d", playerName, playerSplitScore));
			scoreLabelDoubleSplit.setHorizontalAlignment(SwingConstants.CENTER);
			repaint();
		}
		
	}

	void toggleButtonsVisibility() {
		standButton.setVisible(!standButton.isVisible());
		splitButton.setVisible(!splitButton.isVisible());
		doubleButton.setVisible(!doubleButton.isVisible());
		surrenderButton.setVisible(!surrenderButton.isVisible());
		repaint();
	}
	
	
	void toggleInsuranceButtonVisibility() {
		insuranceButton.setVisible(!insuranceButton.isVisible());
		repaint();
	}
	
	void toggleHitButtonVisibility() {
		hitButton.setVisible(!hitButton.isVisible());
		repaint();
	}
	
	void tobbleScoreLabelDoubleSplitVisibility() {
		scoreLabelDoubleSplitIsVisible = !scoreLabelDoubleSplitIsVisible;
		scoreLabelDoubleSplit.setVisible(scoreLabelDoubleSplitIsVisible);
		repaint();
	}
	
	void hideButtonsAndBetLabel() {
		scoreLabelDoubleSplit.setVisible(false);
		betLabel.setVisible(false);
	
		standButton.setVisible(false);
		doubleButton.setVisible(false);
		splitButton.setVisible(false);
		insuranceButton.setVisible(false);
		surrenderButton.setVisible(false);
		hitButton.setVisible(false);
	}
	
	void showButtonsAndBetLabel() {
		scoreLabelDoubleSplit.setVisible(true);
		betLabel.setVisible(true);
	
		standButton.setVisible(true);
		doubleButton.setVisible(true);
		splitButton.setVisible(true);
		insuranceButton.setVisible(true);
		surrenderButton.setVisible(true);
		hitButton.setVisible(true);
	}
	
	void setBalance(int balance) {
		this.balance = balance;
		repaintBalanceLabel();
	}
	
	void setBetValue(int betValue) {
		this.betValue = betValue;
		repaintBetLabel();
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Draws labels outlines
		g.drawRect(betLabel.getX() - 1, betLabel.getY() - 1, betLabel.getWidth() + 1, betLabel.getHeight() + 1);
		g.drawRect(balanceLabel.getX() - 1, balanceLabel.getY() - 1, balanceLabel.getWidth() + 1, balanceLabel.getHeight() + 1);
		
		if (scoreLabelDoubleSplitIsVisible) {
			g.drawRect(scoreLabelDoubleSplit.getX() - 1, scoreLabelDoubleSplit.getY() - 1, scoreLabelSize.x + 1, scoreLabelSize.y + 1);
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
			
			splitButton.addActionListener(this);
			insuranceButton.addActionListener(this);
			hitButton.addActionListener(this);
			standButton.addActionListener(this);
			doubleButton.addActionListener(this);
			
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
			debugPositionReferenceButton.setFont(myFont);
			
			DownerGamePanel.this.add(debugPositionReferenceButton);
			
			debugPositionReferenceButton.setBounds(screenSize.x - 54, 0, cardsSize.x, cardsSize.y);
		}
	}
}
