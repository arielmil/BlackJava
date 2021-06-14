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

public class saveController implements ActionListener {
    
    Deck saveDeck;
    Player savePlayer[];
    
    public saveController(Deck deck, Player players[]) {
        saveDeck = deck;
        savePlayer = players;
    }
    
    public String saveBin() {
        ArrayList<Object> bin = saveDeck.getBin().list;
        String binLine = "";
        
        for(Object item : bin) {
            Card c = (Card)item;
            binLine += c.getName() + '+' + c.getSuitname() + ",";
        }
        
        return binLine;
    }
    
    public String saveDeck() {
        ArrayList<Object> deck = saveDeck.getDeck().list;
        String deckLine = "";
        
        for(Object item : deck) {
            Card c = (Card)item;
            deckLine += c.getName() + '+' + c.getSuitname() + ",";
        }
        
        return deckLine;
    }
    
    public String saveTotalPlayersMoney() {
    	
    	int i;
    	String playerMoneyLine = "";
        
        for(i = 0; i < 4; i++) {
            
        	playerMoneyLine += savePlayer[i].getTotalMoney() + ",";
        }
        
        return playerMoneyLine;
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            Path path = Paths.get("save.txt");
            Files.write(path, saveBin().getBytes() );
            Files.write(path, saveDeck().getBytes() );
            Files.write(path, saveTotalPlayersMoney().getBytes() );
        } catch (Exception ex) {
            //
        }
        
    }
}