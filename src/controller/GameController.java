package controller;

import model.Deck;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameController {
    Deck deck;
    List<Player> players;

    public void startGame(int numberOfPlayers) {
        players = new ArrayList<>(numberOfPlayers);
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(String.format("Player %d", i)));
        }
    }

    public void makeBet(String playerName, int amount) {
        for (Player player : players) {
            if (Objects.equals(player.getName(), playerName)) {
//                player.bet();
                break;
            }
        }
    }
}
