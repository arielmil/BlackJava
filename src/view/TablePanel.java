package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TablePanel extends JPanel {
	private String img_name;
	private Image img;
	private Point panelSize;
	
	public TablePanel(Point screenSize, JPanel foreGround) {
		super();
		
		setLocation(0, 0);
		setLayout(null);
		
		img_name = "blackjackBKG.png";
		img = ImageLoader.load(img_name);
		
		if (foreGround != null) {
			panelSize = new Point(foreGround.getWidth(), foreGround.getHeight());
			
			add(foreGround);
		}
		
		else {
			panelSize = new Point(screenSize.x, screenSize.y);
		}
		
		setSize(panelSize.x, panelSize.y);
		setOpaque(false);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, panelSize.x, panelSize.y, null);
	}
}
