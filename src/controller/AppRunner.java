package controller;

import javax.swing.*;

public class AppRunner extends JFrame {

	private static int WIDTH = 1200;
	private static int HEIGHT = 700;

	private static GameController gameController;

	public static GameController getGameController() {
	    if (gameController == null) {
	        gameController = new GameController();
        }
	    return gameController;
    }
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
		JFrame frame = new JFrame("Blackjack");
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//frame.add(new MainPane(WIDTH, HEIGHT, frame.getInsets()));
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }	
}
