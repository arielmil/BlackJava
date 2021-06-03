package viewTest;

import view.TablePanel;

import javax.swing.*;
import java.awt.Point;

public class TablePanelTest {
	public static void main(String args[]) {
		
		Point screenSize = new Point(1200, 700);
		
		JFrame frame = new JFrame("Table_panel Test");
		frame.setBounds(0, 0, screenSize.x, screenSize.y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		TablePanel TablePanelTest = new TablePanel(screenSize, null);
		
		frame.getContentPane().add(TablePanelTest);
		frame.setVisible(true);
	}
}
