package view;

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
public class OpeningScreen extends JPanel implements ComponentPositionDebuggingInterface, ActionListener{
	
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
		
		if (debugPositioningMode) {
			setDebugPositioningMode();
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		movingComponent = (JButton)e.getSource();
	}
	
	public void buildNewGameButton() {
		newGameButton = new JButton("New Game");
		newGameButton.setToolTipText("Starts a new game");
		
		add(newGameButton);
		
		newGameButton.setBounds((int)(screenSize.x * 0.4), (int)(center.y * 0.9777), 148, 45);
		System.out.println(newGameButton.getBounds());
		newGameButton.setVisible(true);
		newGameButton.addActionListener(this);
	}
	
	public void buildLoadGameButton() {
		loadGameButton = new JButton("Load Game");
		loadGameButton.setToolTipText("Load a previously saved game");
		
		add(loadGameButton);
		
		loadGameButton.setBounds(1098, 528, 148, 45);
		loadGameButton.setVisible(true);
		loadGameButton.addActionListener(this);
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
	
	public void setDebugPositioningMode() {
		mouseEventHandler = new ComponentPositionHelper(this);
		addMouseListener(mouseEventHandler);
		addMouseMotionListener(mouseEventHandler);
	}
	
	public void setChildPosition(Point childNewPosition) {
		movingComponent.setLocation(childNewPosition.x, childNewPosition.y);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//String size = String.format("x: %d, y: %d", g.getFontMetrics().stringWidth("New Game"), g.getFontMetrics().stringWidth("Load game"));
		//System.out.println(size);
	}
	
}
