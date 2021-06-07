package viewTest;

import java.awt.Container;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.UpperGamePanel;
import view.TablePanel;

public class UpperGamePanelTest {
	static private Container contentPane;
	static private Point screenSize;
	static private TablePanel backgroundPanel;
	static private UpperGamePanel Foreground;
	
	public static void main (String args[]) {
		JFrame frame = new JFrame("UpperGamePanel Test");
		contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		
		contentPane.add(backgroundPanel);
				
		frame.setBounds(0,0,screenSize.x, screenSize.y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
				
	}
	
	static{
		
		screenSize = new Point(1200, 700);
		
		Foreground = new UpperGamePanel(screenSize, true);
		backgroundPanel = new TablePanel(screenSize, Foreground);
	}
	
	
}
