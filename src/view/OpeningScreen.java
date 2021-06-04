package view;

import java.awt.AWTEvent;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class OpeningScreen extends JPanel implements ActionListener{
	
	@SuppressWarnings("unused") //For whatever reason, eclipse doesn't recognize that this variable is being used.
	private debugPositioningMode debugPositioning;
	private Boolean debugPositioningMode = false;
	
	private Point center;
	private Point screenSize;
	
	private JPanel playerSelectMenu;
	private JPanel loadGameMenu;
	
	private JButton newGameButton;
	private JButton loadGameButton;
	
	private JRadioButton playerSelectButton[];
	
	private JLabel newGameMenuLabel;
	private JLabel loadGameMenuLabel;
	
	private ButtonGroup playerSelectButtonsGroup;
	
	private MouseAdapter mouseEventHandler;
	
	public OpeningScreen(Point screenSize, Point topContainerCenter) {
		super();
		setBounds(0, 0, screenSize.x, screenSize.y);
		setLayout(null);
		setOpaque(false);
		
		center = topContainerCenter;
		this.screenSize = screenSize;
		
		buildButtons();
		buildPopUpMenus();
		
	}
	
	public OpeningScreen(Point screenSize, Point topContainerCenter, Boolean debugPositioningMode) {
		super();
		
		setBounds(0, 0, screenSize.x, screenSize.y);
		setLayout(null);
		setOpaque(false);
		
		center = topContainerCenter;
		this.screenSize = screenSize;
		
		buildButtons();
		buildPopUpMenus();
		
		this.debugPositioningMode = debugPositioningMode;
		
		setDebugPositioningMode();
		
		
	}
	
	private void buildNewGameButton() {
		newGameButton = new JButton("New Game");
		newGameButton.setToolTipText("Starts a new game");
		
		add(newGameButton);
		
		newGameButton.setBounds(404, center.y, 148, 45);
		newGameButton.setVisible(true);
		
		newGameButton.addActionListener(this);
	}
	
	private void buildLoadGameButton() {
		loadGameButton = new JButton("Load Game");
		loadGameButton.setToolTipText("Load a previously saved game");
		
		add(loadGameButton);
		
		loadGameButton.setBounds(648, center.y, 148, 45);
		loadGameButton.setVisible(true);
		
		if (!debugPositioningMode) {
			loadGameButton.addActionListener(this);
		}
	}
	
	private void buildPlayerSelectButtons() {
		int i;
		JRadioButton button;
		
		playerSelectButtonsGroup = new ButtonGroup();
		playerSelectButton = new JRadioButton[4];
		
		for (i = 0; i < 4; i++) {
			
			button = new JRadioButton(String.format("%d", i + 1));
			
			playerSelectButton[i] = button;
			playerSelectButtonsGroup.add(button);
		}
		
	}
	
	private void buildButtons() {
		buildNewGameButton();
		buildLoadGameButton();
		buildPlayerSelectButtons();
	}
	
	private void setDebugPositioningMode() {
		debugPositioning = new debugPositioningMode();
	}
	
	
	private void buildPopUpMenus() {
		int buttonsY;
				
		playerSelectMenu = new JPanel(null);
		loadGameMenu = new JPanel(null);
		
		Point newGameButtonLocation = newGameButton.getLocation();
		Point loadGameButtonLocation = loadGameButton.getLocation();
		
		playerSelectMenu.setBounds(newGameButtonLocation.x, 144, newGameButton.getWidth(), newGameButtonLocation.y - 144);
		loadGameMenu.setBounds(loadGameButtonLocation.x, 144, loadGameButton.getWidth(), loadGameButtonLocation.y - 144);
				
		add(playerSelectMenu);
		add(loadGameMenu);
		
		buttonsY =  newGameButton.getHeight() - 15;
		
		for (JRadioButton button : playerSelectButton) {
			playerSelectMenu.add(button);
			button.setBounds(7, buttonsY, 35, 35);
			buttonsY = buttonsY + newGameButton.getHeight();
		}
		
		newGameMenuLabel = new JLabel("Select players");
		newGameMenuLabel.setBounds(20, 0, newGameButton.getWidth(), newGameButton.getHeight());
		newGameMenuLabel.setVisible(false);
		
		playerSelectMenu.add(newGameMenuLabel);
		
		playerSelectMenu.setVisible(false);
		loadGameMenu.setVisible(false);
	}
	
	private void changeMenusVisibility() {
		if (loadGameMenu.isVisible()) {
			//loadGameMenuLabel.setVisible(false);
			loadGameMenu.setVisible(false);
		}
		
		else if (playerSelectMenu.isVisible()) {
			newGameMenuLabel.setVisible(false);
			playerSelectMenu.setVisible(false);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton)e.getSource();
		
		if (clickedButton.getText() == "New Game") {
			changeMenusVisibility();
			
			playerSelectMenu.setVisible(true);
			
			for (JRadioButton button : playerSelectButton) {
				button.setVisible(true);
			}
			
			newGameMenuLabel.setVisible(true);
		}
		
		
		else {
			changeMenusVisibility();
			
			loadGameMenu.setVisible(true);
			
			for (JRadioButton button : playerSelectButton) {
				button.setVisible(false);
			}
			
			//loadGameMenuLabel.setVisible(true);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (debugPositioningMode) {
			g.drawLine(center.x, 0, center.x, screenSize.y);
			g.drawLine(0, center.y, screenSize.x, center.y);
			g.drawLine(419 , 0, 419, screenSize.y);
		}
		
	}
	
	private class debugPositioningMode implements ComponentPositionDebuggingInterface, ActionListener {
		private JComponent movingComponent;
		
		public debugPositioningMode() {
			mouseEventHandler = new ComponentPositionHelper(this);
			addMouseListener(mouseEventHandler);
			addMouseMotionListener(mouseEventHandler);
			newGameButton.addActionListener(this);
			loadGameButton.addActionListener(this);
		}
		
		public void setSource(Object source) {
			movingComponent = (JComponent)source;
			if (movingComponent instanceof JButton || movingComponent instanceof JRadioButton) {
				movingComponent = (JComponent)source;
			}
			
		}
		
		public void actionPerformed(ActionEvent e) {
			setSource(e.getSource());
		}
		
		public void setChildPosition(Point childNewPosition, AWTEvent e) {
			
			movingComponent.setLocation(childNewPosition.x, childNewPosition.y);				
		}
	}
}
