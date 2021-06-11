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

// Falta criar o painel das cartas, fazer a logica de se as cartas estiverem para baixo, renderizar a imagem dela para baixo
// Falta criar o painel das fichas, e a logica de elas vão aparecendo conforme se vai apostando, ou diminuindo conforme se vai clicando de volta nelas, até que elas somem

@SuppressWarnings("serial")
public class DownerGamePanel extends AbstractGamePanel{
	
	@SuppressWarnings("unused") //For whatever reason, eclipse doesn't recognize that this variable is being used.
	private DebugPositioningMode debugPositioning;
	
	private Boolean insuranceButtonIsVisible = false;
	
	private int betValue;
	private int balance = 500;
	private int labelsWidth;
	
	private JLabel betLabel;
	private JLabel balanceLabel;
	
	private JButton standButton;
	private JButton doubleButton;
	private JButton splitButton;
	private JButton insuranceButton;
	
	public DownerGamePanel(Point screenSize, String playerName) {
		super(screenSize, playerName);
		
		setLocations();
		
		buildButtons();
		
		buildLabels();
	}
	
	public DownerGamePanel(Point screenSize, String playerName, Boolean debugPositioningMode) {
		super(screenSize, playerName, debugPositioningMode);
		
		setLocations();
		
		buildButtons();
		
		buildLabels();
		
		if (debugPositioningMode) {
			debugPositioning = new DebugPositioningMode();
		}
	}
	
	private void setLocations() {
		//Uses insuranceButton as reference
		buttonsLocation = new Point(screenSize.x - buttonsSize.x * 4, screenSize.y - buttonsSize.y);
	}
	
	private void buildLabels() {
		
		labelsWidth = (int)(scoreLabelSize.x * 0.75);
		
		buildBalanceLabel();
		buildBetLabel();
	}
	
	private void buildBalanceLabel() {
		balanceLabel = new JLabel(String.format("   Balance: %d ", balance), SwingConstants.CENTER);
		balanceLabel.setBounds(1, screenSize.y - scoreLabelSize.y * 2, labelsWidth, scoreLabelSize.y);
		balanceLabel.setOpaque(true);
		add(balanceLabel);
	}
	
	private void buildBetLabel() {
		betLabel = new JLabel(String.format("Bet value: %d", betValue), SwingConstants.CENTER);
		betLabel.setBounds(1, screenSize.y - scoreLabelSize.y + 1, labelsWidth, scoreLabelSize.y);
		betLabel.setOpaque(true);
		add(betLabel);
	}
	
	private void buildButtons() {
		buildStandButton();
		buildInsuranceButton();
		buildSplitButton();
		buildDoubleButton();
	}
	
	private void buildStandButton() {
		standButton = new JButton("Stand");
		standButton.setToolTipText("End turn");
		
		add(standButton);
		
		standButton.setBounds(buttonsLocation.x + buttonsSize.x, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
	
	private void buildInsuranceButton() {
		insuranceButton = new JButton("Insurance");
		insuranceButton.setToolTipText("Get half the value of player's bet if dealer's second card is a ten valued card (10, Jack, Queen or King)");
		
		add(insuranceButton);
		
		insuranceButton.setBounds(buttonsLocation.x, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
		insuranceButton.setVisible(false);
	}
	
	private void buildSplitButton() {
		splitButton = new JButton("Split");
		splitButton.setToolTipText("Take in another hand and doubles the bet (player needs to have at least double of the amount of tokens available to bet)");
		
		add(splitButton);
		
		splitButton.setBounds(buttonsLocation.x + buttonsSize.x * 2, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
	
	private void buildDoubleButton() {
		doubleButton = new JButton("Double");
		doubleButton.setToolTipText("Doubles the bet (player needs to have at least double of the amount of tokens available to bet)");
		
		add(doubleButton);
		
		doubleButton.setBounds(buttonsLocation.x + buttonsSize.x * 3, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
	
	private void repaintBalanceLabel() {
		balanceLabel.setText(String.format("   Balance: %d ", balance));
		balanceLabel.setAlignmentX(SwingConstants.CENTER);
		repaint();
	}
	
	private void repaintBetLabel() {
		betLabel.setText(String.format("Bet value: %d", betValue));
		betLabel.setAlignmentX(SwingConstants.CENTER);
		repaint();
	}
	
	void toggleInsuranceButtonVisibility() {
		insuranceButtonIsVisible = !insuranceButtonIsVisible;
		insuranceButton.setVisible(insuranceButtonIsVisible);
		repaint();
	}
	
	void setBetValue(int betValue) {
		this.betValue = betValue;
		repaintBetLabel();
	}
	
	void setBalance(int balance) {
		this.balance = balance;
		repaintBalanceLabel();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Draws labels outlines
		g.drawLine(1, screenSize.y - scoreLabelSize.y, labelsWidth + 1, screenSize.y - scoreLabelSize.y);
		g.drawRect(0, screenSize.y - scoreLabelSize.y * 2 - 1, labelsWidth + 1, scoreLabelSize.y * 2);
		
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
			DownerGamePanel.this.add(debugPositionReferenceButton);
			
			debugPositionReferenceButton.setBounds(screenSize.x - 54, 0, cardsSize.x, cardsSize.y);
		}
	}
}
