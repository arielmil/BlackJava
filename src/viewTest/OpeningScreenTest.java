// Ariel Mileguir
// Pedro Gabriel 

package viewTest;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;

import view.OpeningScreenPanel;
import view.TablePanel;

class OpeningScreenTest {
	static private JFrame frame;
	
	static private Container contentPane;
	
	static private Point screenSize;
	static private Point PanelsSize;
	
	static private TablePanel backgroundPanel;
	static private OpeningScreenPanel Foreground;
	
	public static void main (String args[]) {
		contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		
		contentPane.add(backgroundPanel);
		frame.repaint();
	}
	
	static{
		Insets frameBorders;
		frame = new JFrame("OpeningScreen Test");
		
		screenSize = new Point(1200, 700);
		
		frame.setBounds(0, 0, screenSize.x, screenSize.y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frameBorders = frame.getInsets();
		PanelsSize = new Point(screenSize.x, screenSize.y - (frameBorders.top + frameBorders.bottom));
		
		Foreground = new OpeningScreenPanel(PanelsSize, true);
		backgroundPanel = new TablePanel(Foreground);
	}
}