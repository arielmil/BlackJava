package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class OpeningScreen extends JPanel {
	private debugPositioningMode debugPositioning;
	private Boolean debugPositioningMode = false;
	private Point center;
	private Point screenSize;
	private JButton newGameButton;
	private JButton loadGameButton;
	private JButton JButtonArray[];
	private ButtonGroup playerSelectButtonsGroup;
	private JRadioButton playerSelectButton[];
	private MouseAdapter mouseEventHandler;
	private JComponent movingComponent;
	
	public OpeningScreen(Point screenSize, Point topContainerCenter) {
		super();
		setBounds(0, 0, screenSize.x, screenSize.y);
		setLayout(null);
		setOpaque(false);
		
		center = topContainerCenter;
		this.screenSize = screenSize;
		
		JButtonArray = new JButton[2];
		
		buildNewGameButton();
		buildLoadGameButton();
		
		JButtonArray[0] = newGameButton;
		JButtonArray[1] = loadGameButton;
	}
	
	public OpeningScreen(Point screenSize, Point topContainerCenter, Boolean debugPositioningMode) {
		super();
		
		setBounds(0, 0, screenSize.x, screenSize.y);
		setLayout(null);
		setOpaque(false);
		
		center = topContainerCenter;
		this.screenSize = screenSize;
		
		JButtonArray = new JButton[2];

		buildNewGameButton();
		buildLoadGameButton();
		
		JButtonArray[0] = newGameButton;
		JButtonArray[1] = loadGameButton;
		
		this.debugPositioningMode = debugPositioningMode;
		if (debugPositioningMode) {
			setDebugPositioningMode();
		}
		
	}
	
	public void buildNewGameButton() {
		newGameButton = new JButton("New Game");
		newGameButton.setToolTipText("Starts a new game");
		
		add(newGameButton);
		
		newGameButton.setBounds(404, center.y, 148, 45);
		System.out.println(newGameButton.getBounds());
		newGameButton.setVisible(true);
	}
	
	public void buildLoadGameButton() {
		loadGameButton = new JButton("Load Game");
		loadGameButton.setToolTipText("Load a previously saved game");
		
		add(loadGameButton);
		System.out.printf("%d",center.x);
		loadGameButton.setBounds(648, center.y, 148, 45);
		loadGameButton.setVisible(true);
	}
	
	public void buildPlayerSelectButtons() {
		int i;
		
		playerSelectButtonsGroup = new ButtonGroup();
		playerSelectButton = new JRadioButton[4];
		
		for (i = 0; i < 4; i++) {
			playerSelectButton[i] = new JRadioButton(String.format("%d", i + 1));
			playerSelectButtonsGroup.add(playerSelectButton[i]);
			add(playerSelectButton[i]);
		}
		
	}
	
	private void setDebugPositioningMode() {
		debugPositioning = new debugPositioningMode();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (debugPositioningMode) {
			g.drawLine(center.x, 0, center.x, screenSize.y);
			g.drawLine(0, center.y, screenSize.x, center.y);
		}
	}
	
	private class debugPositioningMode implements ComponentPositionDebuggingInterface, ActionListener {
		
		public debugPositioningMode() {
			mouseEventHandler = new ComponentPositionHelper(this);
			addMouseListener(mouseEventHandler);
			addMouseMotionListener(mouseEventHandler);
			newGameButton.addActionListener(this);
			loadGameButton.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e) {
			movingComponent = (JButton)e.getSource();
		}
		
		public void setChildPosition(Point childNewPosition) {
			movingComponent.setLocation(childNewPosition.x, childNewPosition.y);
		}
	}
}
