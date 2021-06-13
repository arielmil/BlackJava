package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.AppRunner;
import controller.GameController;
import controller.MainPane;

@SuppressWarnings("serial")
public class OpeningScreen extends JPanel implements ActionListener{

	private GameController gameController;
	
	@SuppressWarnings("unused") //For whatever reason, eclipse doesn't recognize that this variable is being used.
	private DebugPositioningMode debugPositioning;
	private Boolean debugPositioningMode = false;
	
	private Point center;
	private Point screenSize;
	
	private JPanel playerSelectMenu;
	private JPanel loadGameMenu;
	
	private JButton newGameButton;
	private JButton loadGameButton;
	private JButton okButton;
	
	private JRadioButton playerSelectButton[];
	
	private ButtonGroup playerSelectButtonsGroup;
	
	private MouseAdapter mouseEventHandler;
	
	
	public OpeningScreen(Point screenSize) {
		super();

		gameController = AppRunner.getGameController();

		setBounds(0, 0, screenSize.x, screenSize.y);
		setLayout(null);
		setOpaque(false);
		
		center = new Point(screenSize.x/2, screenSize.y/2);
		this.screenSize = screenSize;
		
		buildButtons();
		buildPopUpMenus();
	}
	
	public OpeningScreen(Point screenSize, Boolean debugPositioningMode) {
		super();

		gameController = AppRunner.getGameController();
		
		setBounds(0, 0, screenSize.x, screenSize.y);
		setLayout(null);
		setOpaque(false);
		
		center = new Point(screenSize.x/2, screenSize.y/2);
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
		
		newGameButton.addActionListener(this);
	}
	
	private void buildLoadGameButton() {
		loadGameButton = new JButton("Load Game");
		loadGameButton.setToolTipText("Load a previously saved game");
		
		add(loadGameButton);
		
		loadGameButton.setBounds(648, center.y, 148, 45);
		
		loadGameButton.addActionListener(this);
	}
	
	private void buildOkButton() {
		okButton = new JButton("Ok");
		okButton.setToolTipText("Confirm selected players");
		
		okButton.setBounds(148 - 55, 206 - 45, 55, 45);
		
		okButton.addActionListener(this);
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
		buildOkButton();
	}
		
	private void buildPopUpMenus() {
		int buttonsY;
		
		Point newGameButtonLocation = newGameButton.getLocation();
		Point loadGameButtonLocation = loadGameButton.getLocation();
		
		playerSelectMenu = new JPanel() {
			{
				setLayout(null);
				setBounds(newGameButtonLocation.x, 144, newGameButton.getWidth(), newGameButtonLocation.y - 144);
			}
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawString("Select players", 30, 25);
			}
		};
		
		loadGameMenu = new JPanel(null);		
		loadGameMenu.setBounds(loadGameButtonLocation.x, 144, loadGameButton.getWidth(), loadGameButtonLocation.y - 144);
				
		add(playerSelectMenu);
		add(loadGameMenu);
		
		playerSelectMenu.add(okButton);
		
		buttonsY =  newGameButton.getHeight() - 13;
		
		for (JRadioButton button : playerSelectButton) {
			playerSelectMenu.add(button);
			button.setBounds(7, buttonsY, 35, 35);
			buttonsY = buttonsY + newGameButton.getHeight();
		}
				
		playerSelectMenu.setVisible(false);
		loadGameMenu.setVisible(false);
	}
	
	private void setDebugPositioningMode() {
		debugPositioning = new DebugPositioningMode();
	}
	
	private void changeMenusVisibility() {
		if (loadGameMenu.isVisible()) {
			loadGameMenu.setVisible(false);
		}
		
		else if (playerSelectMenu.isVisible()) {
			playerSelectMenu.setVisible(false);
			okButton.setVisible(false);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton)e.getSource();
		
		changeMenusVisibility();
		
		if (clickedButton.getText() == "New Game") {
			playerSelectMenu.setVisible(true);
			
			for (JRadioButton button : playerSelectButton) {
				button.setVisible(true);
			}
			
			okButton.setVisible(true);
		}
		
		
		else if (clickedButton.getText() == "Load Game") {			
			loadGameMenu.setVisible(true);
			
			for (JRadioButton button : playerSelectButton) {
				button.setVisible(false);
			}
			
		}
		
		else if (clickedButton.getText() == "Ok") {
			for (JRadioButton button : playerSelectButton) {
				if (button.isSelected()) {
					int numberOfPlayers = Integer.parseInt(button.getText());
					gameController.startGame(numberOfPlayers);
					MainPane mainPane = (MainPane) this.getParent().getParent();
					((CardLayout) mainPane.getLayout()).show(mainPane, MainPane.DOWNER_VIEW);
					return;
				}
			}
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
	
	private class DebugPositioningMode implements ComponentPositionDebuggingInterface, ActionListener {
		private JComponent movingComponent;
		
		public DebugPositioningMode() {
			mouseEventHandler = new ComponentPositionHelper(this);
			
			addMouseListener(mouseEventHandler);
			addMouseMotionListener(mouseEventHandler);
			
			newGameButton.addActionListener(this);
			loadGameButton.addActionListener(this);
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
	}
}
