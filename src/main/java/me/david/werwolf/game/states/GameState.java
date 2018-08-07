package me.david.werwolf.game.states;

import me.david.werwolf.game.State;

public abstract class GameState extends State {

    public GameState(String name) {
        super(name);
    }

    @Override
    public void playerJoin(String player) {

    }

    @Override
    public void playerLeave(String player) {

    }
}
