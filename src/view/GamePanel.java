package view;

import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

//Ver primeiro comentario em UpperGamePanel
//Criar um método que escala uma coordenada x e y baseado em um tamanho de tela (largura x altura) para escalar todos os elementos dessa classe de acordo com o tamanho de tela utilizado.
@SuppressWarnings("serial")
class GamePanel extends JPanel {
	Boolean debugPositioningMode = false;
	
	int playerScore;
	
	String playerName;
	
	Point screenSize;
	Point center;
	
	private JPanel infoPanel;
	private JLabel infoLabel;
	
	public GamePanel(Point screenSize) {
		super();
		
		setLayout(null);
		setBounds(0, 0, screenSize.x, screenSize.y);
		setOpaque(false);
		
		this.screenSize = screenSize;
		center = new Point(screenSize.x/2, screenSize.y/2);
		
		infoPanel = new JPanel(null);
		infoPanel.setBounds(936, 0, 264, 45);
		add(infoPanel);
		
		infoLabel = new JLabel();
		infoLabel.setText("Mock");
		infoLabel.setBounds(5, 0, 264, 45);
		infoPanel.add(infoLabel);
	}
	
	void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
}
