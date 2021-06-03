package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TablePanel extends JPanel {
	private String img_name;
	private Image img;
	private Point screenSize;
	
	public TablePanel(Point screenSize, OpeningScreen Foreground) {
		super();
		
		setBounds(0, 0, screenSize.x, screenSize.y);
		setLayout(null);
		
		img_name = "blackjackBKG.png";
		img = ImageLoader.load(img_name);
		
		if (Foreground != null) {
			add(Foreground);
		}
		
		setOpaque(false);
		
		this.screenSize = screenSize;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, screenSize.x, screenSize.y, null);
	}
}
