package ru.netology.game;

import java.util.*;

public class Game {
    private Map<String,Player> players;

    public Game() {
        this.players = new LinkedHashMap<>();
    }

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public Collection<Player> findAll() {
        return new ArrayList<>(players.values());
    }

//    public Player findByName(String playerName) {
//        for (Player player : players) {
//            if (player.getName() == playerName) {
//                return player;
//            }
//        }
//        return null;
//    }

    public int round(String playerName1, String playerName2) {
        if (!players.containsKey(playerName1) && !players.containsKey(playerName2)) {
            throw new NotRegisteredException("Players" + playerName1 + "," + playerName2 + "not registered");
        }
        if (!players.containsKey(playerName1)) {
            throw new NotRegisteredException("Player" + playerName1 + "not registered");
        }
        if (!players.containsKey(playerName2)) {
            throw new NotRegisteredException("Player" + playerName2 + "not registered");
        }

        if (players.get(playerName1).getStrength() - players.get(playerName2).getStrength() == 0) {
            return 0;
        }
        if (players.get(playerName1).getStrength() - players.get(playerName2).getStrength() > 0) {
            return 1;
        } else {
            return 2;
        }
    }
}
