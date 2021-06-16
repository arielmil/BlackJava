// Ariel Mileguir
// Pedro Gabriel 

package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Card;
import model.Deck;
import model.Player;

public class SaveController  {


    public SaveController() {

    }

    public String saveBin(Deck saveDeck) {
        ArrayList<Object> bin = saveDeck.getBin().list;
        String binLine = "";

        for(Object item : bin) {
            Card c = (Card)item;
            binLine += String.valueOf(c.getValue()) + '+' + c.getName() + '+' +  c.getSuitname() + ",";
        }


        return binLine;
    }

    public String saveDeck(Deck saveDeck) {
        ArrayList<Object> deck = saveDeck.getDeck().list;
        String deckLine = "";

        for(Object item : deck) {
            Card c = (Card)item;
            deckLine += String.valueOf(c.getValue()) + '+' + c.getName() + '+' + c.getSuitname() + ",";
        }


        return deckLine;
    }

    public String saveTotalPlayersMoney(Player savePlayers[]) {
    	String playerMoneyLine = "";

    	for(Player player: savePlayers) {
        	playerMoneyLine += player.getTotalMoney() + ",";
        }

        return playerMoneyLine;
    }

    public void saveGame(Deck saveDeck, Player savePlayers []) {
        try {
            BufferedWriter bw = new BufferedWriter (new FileWriter("save.txt"));

            bw.write(saveBin(saveDeck));
            bw.newLine();
            bw.write(saveDeck(saveDeck));
            bw.newLine();
            bw.write(saveTotalPlayersMoney(savePlayers));

            bw.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }
} 