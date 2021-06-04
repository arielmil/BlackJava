package view;

import java.awt.AWTEvent;
import java.awt.Point;

public interface ComponentPositionDebuggingInterface {
	public void setChildPosition(Point p, AWTEvent e);
	public void setSource(Object source);
}
