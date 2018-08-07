package me.david.werwolf.game.states;

import me.david.werwolf.game.Game;
import me.david.werwolf.game.State;

import java.util.HashSet;
import java.util.Set;


public class LobbyState extends State {

    private Set<String> players = new HashSet<>();

    public LobbyState() {
        super("Lobby");
    }

    @Override
    public void onEnable(Game game) {

    }

    @Override
    public void onDisable(Game game) {

    }

    @Override
    public void playerJoin(String player) {
        players.add(player);
    }

    @Override
    public void playerLeave(String player) {
        players.remove(player);
    }

}
