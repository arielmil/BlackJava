package viewTest;

import view.TablePanel;

import javax.swing.*;

import java.awt.Insets;
import java.awt.Point;

public class TablePanelTest {
	public static void main(String args[]) {
		Insets frameInsets;
		Point TablePanelSize;
		
		Point screenSize = new Point(1200, 700);
		JFrame frame = new JFrame("Table_panel Test");
		
		frame.setLayout(null);
		frame.setBounds(0, 0, screenSize.x, screenSize.y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		frame.setVisible(true);
		
		frameInsets = frame.getInsets();
		TablePanelSize = new Point(screenSize.x, screenSize.y - (frameInsets.top + frameInsets.bottom));
		
		TablePanel TablePanelTest = new TablePanel(TablePanelSize, null);
		
		frame.getContentPane().add(TablePanelTest);
	}
}
