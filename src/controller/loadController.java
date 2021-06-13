package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import model.Card;
import model.Deck;
import model.List;
import model.Player;

public class loadController implements ActionListener {
    
    Deck loadDeck;
    Player loadPlayer[];
    
    public loadController(Deck deck, Player players[]) {
        loadDeck = deck;
        loadPlayer = players;
    }
    
    public String getBin() {
        ArrayList<Object> bin = loadDeck.getBin().list;
        String linhaBin = "";
        
        for(Object item : bin) {
            Card c = (Card)item;
            linhaBin += c.getName() + '+' + c.getSuitname() + ",";
        }
        
        return linhaBin;
    }
    
    public String getDeck() {
        ArrayList<Object> deck = loadDeck.getDeck().list;
        String linhaDeck = "";
        
        for(Object item : deck) {
            Card c = (Card)item;
            linhaDeck += c.getName() + '+' + c.getSuitname() + ",";
        }
        
        return linhaDeck;
    }
    
  /*  public String getTotalMoney() {
    	
        ArrayList<Object> players = savePlayer[0].getTotalMoney().list;
        String linhaPlayersMoney = "";
        
        for(Object item : players) {
            Player c = (Player)item;
            linhaPlayersMoney += c.getTotalMoney() + ",";
        }
        
        return linhaPlayersMoney;
    }*/
    
    public void actionPerformed(ActionEvent e) {
        try {
            Path path = Paths.get("saves/1.txt");
            Files.write(path, "test".getBytes());
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