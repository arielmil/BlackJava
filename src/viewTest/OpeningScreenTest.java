package viewTest;

import java.awt.Container;
import java.awt.Point;

import javax.swing.JFrame;

import view.OpeningScreen;
import view.TablePanel;

public class OpeningScreenTest {
	static private Container contentPane;
	static private Point screenSize;
	static private TablePanel backgroundPanel;
	static private OpeningScreen Foreground;
	
	public static void main (String args[]) {
		JFrame frame = new JFrame("OpeningScreen Test");
		contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		
		contentPane.add(backgroundPanel);
		
		frame.setBounds(0, 0, screenSize.x, screenSize.y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		System.out.println(frame.getInsets());

	}
	
	static{		
		screenSize = new Point(1200, 700);
		
		Foreground = new OpeningScreen(screenSize, true);
		backgroundPanel = new TablePanel(screenSize, Foreground);
	}
}
