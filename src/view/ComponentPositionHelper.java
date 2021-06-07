package view;

import java.awt.Point;
import java.awt.event.*;

public class ComponentPositionHelper extends MouseAdapter{
	private ComponentPositionDebuggingInterface parent;
	
	public ComponentPositionHelper(ComponentPositionDebuggingInterface parent) {
		super();
		this.parent = parent;
	}
	
	public void mouseClicked(MouseEvent e) {
		Point location = e.getPoint();
		String locationString = String.format("x: %d, y: %d", location.x, location.y);
		System.out.println(locationString);
	}
	
	public void mouseDragged(MouseEvent e) {
		parent.setChildPosition(e.getPoint(), e);
	}
}
