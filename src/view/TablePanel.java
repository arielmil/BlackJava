package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class TablePanel extends JPanel {
	private String img_name;
	private Image img;
	private Point panelSize;
	
	public TablePanel(Point screenSize, JPanel foreGround) {
		super();
		
		setLayout(null);
		
		img_name = "blackjackBKG.png";
		img = ImageLoader.load(img_name);
		
		panelSize = new Point(screenSize.x, screenSize.y);
		
		setBounds(0, 0, panelSize.x, panelSize.y);
		setOpaque(false);
	}
	
	public TablePanel(JPanel foreGround) {
		super();
		
		setLayout(null);
		
		img_name = "blackjackBKG.png";
		img = ImageLoader.load(img_name);
		
		panelSize = new Point(foreGround.getWidth(), foreGround.getHeight());
		
		setBounds(0, 0, panelSize.x, panelSize.y);
		setOpaque(false);
		
		add(foreGround);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, panelSize.x, panelSize.y, null);
	}
}
