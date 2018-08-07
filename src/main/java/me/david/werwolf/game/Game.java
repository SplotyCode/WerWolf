package me.david.werwolf.game;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import lombok.Getter;
import lombok.Setter;
import me.david.werwolf.game.states.LobbyState;
import me.david.werwolf.utils.Pair;

import java.util.HashMap;
import java.util.Map;

public class Game {

    @Getter private final String owner;
    @Getter private Map<String, Roles> players = new HashMap<>();
    @Getter private BiMap<Roles, String> singleRolePlayers = HashBiMap.create();
    @Getter private State state = new LobbyState();
    @Getter private Pair<String, String> armor;
    @Getter @Setter private int round;

    public Game(final String owner) {
        this.owner = owner;
    }

    public boolean isIngame() {
        return !(state instanceof LobbyState);
    }

    public void switchStae(State newState) {
        state.onDisable(this);
        state = newState;
        state.onEnable(this);
    }

    public boolean isFirstRound() {
        return round == 1;
    }


}
