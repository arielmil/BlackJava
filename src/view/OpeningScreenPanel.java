// Ariel Mileguir
// Pedro Gabriel 

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

import controller.API;
import controller.LoadController;

@SuppressWarnings("serial")
public class OpeningScreenPanel extends JPanel implements ActionListener{

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
	private LoadController loadController;
	
	
	public OpeningScreenPanel(Point screenSize) {
		super();
		loadController = new LoadController();

		setBounds(0, 0, screenSize.x, screenSize.y);
		setLayout(null);
		setOpaque(false);
		
		center = new Point(screenSize.x/2, screenSize.y/2);
		this.screenSize = screenSize;
		
		buildButtons();
		buildPopUpMenus();
	}
	
	public OpeningScreenPanel(Point screenSize, Boolean debugPositioningMode) {
		super();
		
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
		
		newGameButton.setBounds(ResizingTool.resizeX(screenSize.x, 404), center.y, ResizingTool.resizeX(screenSize.x, 148), ResizingTool.resizeY(screenSize.y, 45));
		
		newGameButton.addActionListener(this);
	}
	
	private void buildLoadGameButton() {
		loadGameButton = new JButton("Load Game");
		loadGameButton.setToolTipText("Load a previously saved game");
		
		add(loadGameButton);
		
		loadGameButton.setBounds(ResizingTool.resizeX(screenSize.x, 648), center.y, ResizingTool.resizeX(screenSize.x, 148), ResizingTool.resizeY(screenSize.y, 45));
		
		loadGameButton.addActionListener(new ActionListener(){

	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	        	
	        	loadController.loadGame();
	        	
	        }});
	}
	
	private void buildOkButton() {
		int resized55, resized45;
		
		okButton = new JButton("Ok");
		okButton.setToolTipText("Confirm selected players");
		
		resized55 = ResizingTool.resizeX(screenSize.x, 55);
		resized45 = ResizingTool.resizeY(screenSize.y, 45);
		
		okButton.setBounds(newGameButton.getWidth() - resized55, ResizingTool.resizeY(screenSize.y, newGameButton.getY() - 144) - resized45, resized55, resized45);
		
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
		int resized144;
		int buttonsY;
		
		Point newGameButtonLocation = newGameButton.getLocation();
		Point loadGameButtonLocation = loadGameButton.getLocation();
		
		resized144 = ResizingTool.resizeY(screenSize.y, newGameButtonLocation.y - 144);
		
		playerSelectMenu = new JPanel() {
			{
				setLayout(null);
				setBounds(newGameButtonLocation.x, newGameButtonLocation.y - resized144, newGameButton.getWidth(), resized144);
			}
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawString("Select players", ResizingTool.resizeX(screenSize.x, 30), ResizingTool.resizeY(screenSize.y, 25));
			}
		};
		
		loadGameMenu = new JPanel(null);		
		loadGameMenu.setBounds(loadGameButtonLocation.x, loadGameButtonLocation.y - resized144, loadGameButton.getWidth(), resized144);
				
		add(playerSelectMenu);
		add(loadGameMenu);
		
		playerSelectMenu.add(okButton);
		
		buttonsY =  newGameButton.getHeight() - ResizingTool.resizeY(screenSize.y, 13);
		
		for (JRadioButton button : playerSelectButton) {
			playerSelectMenu.add(button);
			button.setBounds(ResizingTool.resizeX(screenSize.x, 7), buttonsY, ResizingTool.resizeX(screenSize.x, 35), ResizingTool.resizeY(screenSize.y, 35));
			buttonsY = buttonsY + ResizingTool.resizeY(screenSize.y, newGameButton.getHeight());
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
		
		else { 
			for (JRadioButton button: playerSelectButton) {
				if (button.isSelected()) {
					API.startGame(Integer.parseInt(button.getText()));
				}
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (debugPositioningMode) {
			g.drawLine(center.x, 0, center.x, screenSize.y);
			g.drawLine(0, center.y, screenSize.x, center.y);
			g.drawLine(ResizingTool.resizeX(screenSize.x, 419), 0, ResizingTool.resizeY(screenSize.y, 419), screenSize.y);
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