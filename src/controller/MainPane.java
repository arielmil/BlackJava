package controller;

import view.DownerGamePanel;
import view.OpeningScreen;
import view.TablePanel;

import javax.swing.*;
import java.awt.*;

public class MainPane extends JPanel {
    public static final String OPENING_VIEW = "view.opening";
    public static final String DOWNER_VIEW = "view.downer";

    public CardLayout cardLayout;

    public MainPane(int width, int height, Insets frameBorders) {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        Point panelsSize = new Point(width, height - (frameBorders.top + frameBorders.bottom));

        TablePanel openingView = new TablePanel(new OpeningScreen(panelsSize));
        TablePanel downerView = new TablePanel(new DownerGamePanel(panelsSize, "Player 1"));

        add(openingView, OPENING_VIEW);
        add(downerView, DOWNER_VIEW);

        cardLayout.show(this, OPENING_VIEW);
    }
}
