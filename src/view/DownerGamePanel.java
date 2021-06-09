package view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;

// Falta criar o painel das cartas, fazer a logica de se as cartas estiverem para baixo, renderizar a imagem dela para baixo
// Falta criar o painel das fichas, e a logica de elas vão aparecendo conforme se vai apostando, ou diminuindo conforme se vai clicando de volta nelas, até que elas somem
// Falta criar o painel que terá um JLabel com o valor da aposta do jogador
// Falta criar o painel que terá um JLabel com a quantidade de fichas que o jogador possuí
// Falta criar a função que muda a visibilidade de insurance quando estiver na hora
// Falta criar a função que altera o valor da aposta
// Falta criar a função que altera o a quantidade de fichas que o jogador possuí

@SuppressWarnings("serial")
public class DownerGamePanel extends AbstractGamePanel{
	
	@SuppressWarnings("unused") //For whatever reason, eclipse doesn't recognize that this variable is being used.
	private DebugPositioningMode debugPositioning;
	
	private int betValue;
	private int totalTokensValue;
	
	private JButton standButton;
	private JButton doubleButton;
	private JButton splitButton;
	private JButton insuranceButton;
		
	public DownerGamePanel(Point screenSize, String playerName) {
		super(screenSize, playerName);
		
		setLocations();
		
		buildButtons();
	}
	
	public DownerGamePanel(Point screenSize, String playerName, Boolean debugPositioningMode) {
		super(screenSize, playerName, debugPositioningMode);
		
		setLocations();
		
		buildButtons();
		
		if (debugPositioningMode) {
			debugPositioning = new DebugPositioningMode();
		}
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
		
		doubleButton.setBounds(buttonsLocation.x + + buttonsSize.x * 3, buttonsLocation.y, buttonsSize.x, buttonsSize.y);
	}
	
	private void setLocations() {
		//Uses insuranceButton as reference
		buttonsLocation = new Point(screenSize.x - buttonsSize.x * 4, screenSize.y - buttonsSize.y);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (debugPositioningMode) {
			g.drawLine(screenSize.x/2, 0, screenSize.x/2, screenSize.y);
			g.drawLine(0, screenSize.y/2, screenSize.x, screenSize.y/2);
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
			
			debugPositionReferenceButton.setBounds(screenSize.x - 54, 0, 54, 54);
		}
	}
}
