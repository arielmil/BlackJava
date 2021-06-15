// Ariel Mileguir
// Pedro Gabriel 

package viewTest;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;

import view.DownerGamePanel;
import view.ResizingTool;
import view.TablePanel;

class DownerGamePanelTest {
static private JFrame frame;
	
	static private Container contentPane;
	
	static private Point screenSize;
	static private Point PanelsSize;
	
	static private TablePanel backgroundPanel;
	static private DownerGamePanel Foreground;
	
	public static void main (String args[]) {
		contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		
		contentPane.add(backgroundPanel);
		frame.repaint();
	}
	
	static {
		Insets frameBorders;
		Point locationOnFrame = new Point(0, 0);
		
		frame = new JFrame("DownerGamePanel Test");
		
		screenSize = new Point(1200/4, 700/2);
		
		frame.setBounds(0, 0, screenSize.x, screenSize.y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frameBorders = frame.getInsets();
		ResizingTool.setBorderSizeY(frameBorders.top);
		
		PanelsSize = new Point(screenSize.x, screenSize.y - (frameBorders.top + frameBorders.bottom));
		
		
		DownerGamePanel.setPlayersQuantity(4);
		Foreground = new DownerGamePanel(locationOnFrame, PanelsSize, "Player 1", 1);
		
		backgroundPanel = new TablePanel(Foreground);
	}
}