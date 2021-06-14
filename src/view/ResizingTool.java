// Ariel Mileguir
// Pedro Gabriel 

package view;

import java.awt.Point;

public class ResizingTool {
	static int borderSizeY;
	
	public static int resizeX(int screenSizeX, int elementXPosition) {
		return (screenSizeX * elementXPosition)/1200;
	}
	
	public static int resizeY(int screenSizeY, int elementYPosition) {
		return (screenSizeY * elementYPosition)/(700 - borderSizeY);
	}
	
	public static Point resizePoint(Point screenSize, Point elementPosition) {
		Point resizedPoint = new Point(resizeX(screenSize.x, elementPosition.x), resizeY(screenSize.y, elementPosition.y));
		return resizedPoint;
	}
	
	public static void setBorderSizeY(int value) {
		borderSizeY = value;
	}
}
