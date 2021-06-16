// Ariel Mileguir
// Pedro Gabriel 

package controller;

import java.io.BufferedReader;
import java.io.FileReader;

import model.List;

import model.Card;
import model.Deck;
import model.Player;
import model.Suit;

public class LoadController {

	public void loadGame() {
		String binLine;
		String deckLine;
		String playersTotalMoneyLine;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("save.txt"));
			binLine = br.readLine();
			deckLine = br.readLine();
			playersTotalMoneyLine = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		Deck deck = new Deck();

		for (String rawCard : binLine.split(",")) {
			if (rawCard.isEmpty()) {
				continue;
			}

			String rawCardAttrs[] = rawCard.split("\\+");
			Suit suit = new Suit(rawCardAttrs[2]);
			Card card = new Card(Integer.parseInt(rawCardAttrs[0]), rawCardAttrs[1], suit);

			deck.addToBin(card);
		}
		
		List innerDeck = new List();
		for (String rawCard : deckLine.split(",")) {
			if (rawCard.isEmpty()) {
				continue;
			}

			String rawCardAttrs[] = rawCard.split("\\+");
			Suit suit = new Suit(rawCardAttrs[2]);
			Card card = new Card(Integer.parseInt(rawCardAttrs[0]), rawCardAttrs[1], suit);

			innerDeck.insertL(card);
		}
		deck.setDeck(innerDeck);
		
		String playersTotalMoney[] = playersTotalMoneyLine.split(",");
		Player players[] = new Player[playersTotalMoney.length];
		int index = 0;
		for (String rawTotalMoney : playersTotalMoney) {
			if (rawTotalMoney.isEmpty()) {
				continue;
			}
			
			players[index] = new Player("Player" + String.valueOf(index));
			players[index].loadTotalMoney(Integer.parseInt(rawTotalMoney));
			index++;
		}
		
		API.loadGame(deck, players);
	}

}