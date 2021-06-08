package view;

import java.awt.Point;

@SuppressWarnings("serial")
public class DownerGamePanel extends GamePanel{
	
	
	public DownerGamePanel(Point screenSize, String playerName) {
		super(screenSize, playerName);
	}
	
	public DownerGamePanel(Point screenSize, String playerName, Boolean debugPositioningMode) {
		super(screenSize, playerName, debugPositioningMode);
	}
}
