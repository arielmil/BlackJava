package view;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;

//Essa é a classe responsável por ser a tela do jogo (relativa ao Desktop) todas as outras "telas" serão JPanels inseridos nela.
//Esses JPanels ficarão visiveis / serão ouvidos ou não de acordo com o contexto do jogo.

@SuppressWarnings("serial")
public class BlackJavaFrame extends JFrame {
	private int playersQuantity;
	private String playerNames[];
	
	private Container contentPane;
	
	private OpeningScreenPanel openingScreenPanel;
	private UpperGamePanel dealerPanel;
	private DownerGamePanel playerPanels[];
	
	private Point screenSize, openingScreenPanelSize, dealerPanelSize, playerPanelsSize;
	
	private TablePanel openingScreenPanelBackground, dealerPanelBackground, playerPanelsBackground;
	
	public BlackJavaFrame(int playersQuantity) {
		Insets frameBorders;
		
		this.playersQuantity = playersQuantity;
		playerNames = new String[playersQuantity];
		
		screenSize = new Point(1200, 700);
		
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setVisible(true);
		frameBorders = getInsets();
		
		contentPane = getContentPane();
		contentPane.setLayout(null);
		
		setPanelSizes(screenSize, frameBorders);
		startPanels();
		
	}
	
	private void setPanelSizes(Point screenSize, Insets frameBorders) {
		openingScreenPanelSize = new Point(screenSize.x, screenSize.y - (frameBorders.top + frameBorders.bottom));
		dealerPanelSize = new Point(openingScreenPanelSize.x, openingScreenPanelSize.y / 2);
		playerPanelsSize = new Point(openingScreenPanelSize.x / playersQuantity, openingScreenPanelSize.y/2);
	}
	
	private void startPanels() {
		startOpeningPanel();
		startDealerPanel();
		startPlayerPanels();
	}
	
	private void startOpeningPanel() {
		openingScreenPanel = new OpeningScreenPanel(openingScreenPanelSize);
		
		add(openingScreenPanel);
	}
	
	private void startDealerPanel() {
		//dealerPanel = new UpperGamePanel(dealerPanelSize);
		dealerPanel.setVisible(false);
		add(dealerPanel);
	}
	
	private void startPlayerPanels() {
		int i;
		for (i = 0; i < playersQuantity; i++) {
			//playerPanels[i] = new DownerGamePanel(playerPanelsSize, playerNames[i]);
			add(playerPanels[i]);
		}
	}
	
}
