package view;

import java.awt.Point;

class ResizingTool {
	static int resizeX(int screenSizeX, int elementXPosition) {
		return (screenSizeX * elementXPosition)/1200;
	}
	
	static int resizeY(int screenSizeY, int elementYPosition) {
		return (screenSizeY * elementYPosition)/700;
	}
	
	static Point resizePoint(Point screenSize, Point elementPosition) {
		Point resizedPoint = new Point(resizeX(screenSize.x, elementPosition.x), resizeY(screenSize.y, elementPosition.y));
		return resizedPoint;
	}
	
}
