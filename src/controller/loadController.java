// Ariel Mileguir
// Pedro Gabriel 

package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.Card;
import model.Deck;
import model.Player;

public class loadController implements ActionListener {
    
    Deck loadDeck;
    Player loadPlayer[];
    
    public loadController(Deck deck, Player players[]) {
        loadDeck = deck;
        loadPlayer = players;
    }
    
    
    
    
    public void actionPerformed(ActionEvent e) {
        try {
        	String[] content;
            Path path = Paths.get("saves.txt");
        //    Files.read(content, "".getBytes());
        } catch (Exception ex) {
            //
        }
        
    }

    
    public void loadBin(String linhaBin) {
        // "Two+Club,Five+Spades,Ace+Diamonds"
        linhaBin.split(",");
        // "Two+Club" "Five+Spade" "Ace+Diamonds"
        linhaBin.split("+");
        // "Two" "Club"
        // "Five" "Spade"
        // "Ace" "Diamonds"
    }
}