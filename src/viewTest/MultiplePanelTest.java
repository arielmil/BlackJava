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
import view.UpperGamePanel;

public class MultiplePanelTest {
	
static private JFrame frame;
	
	static private Container contentPane;
	
	static private Point screenSize;
	static private Point PanelsSize;
	
	static private TablePanel backgroundPanel;
	static private TablePanel backgroundPanel_2;
	
	static private DownerGamePanel Foreground;
	
	
	public static void main (String args[]) {
		contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		
		contentPane.add(backgroundPanel);
		contentPane.add(backgroundPanel_2);
		frame.repaint();
	}
	
	static {
		Insets frameBorders;
		
		frame = new JFrame("DownerGamePanel Test");
		
		screenSize = new Point(1200, 700);
		
		frame.setBounds(0, 0, screenSize.x, screenSize.y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frameBorders = frame.getInsets();
		ResizingTool.setBorderSizeY(frameBorders.top);
		
		PanelsSize = new Point(screenSize.x, (screenSize.y - (frameBorders.top + frameBorders.bottom))/2);
		
		
		DownerGamePanel.setPlayersQuantity(1);
		Foreground = new DownerGamePanel(new Point(0,320),new Point(PanelsSize.x, PanelsSize.y), "Player 1");
		UpperGamePanel Foreground_2 = new UpperGamePanel(PanelsSize);
		
		backgroundPanel = new TablePanel(Foreground);
		backgroundPanel_2 = new TablePanel(Foreground_2);
	}
	

}
