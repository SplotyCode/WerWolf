package me.david.werwolf.game;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class State {

    private String name;

    public abstract void onEnable(Game game);
    public abstract void onDisable(Game game);

    public abstract void playerJoin(String player);
    public abstract void playerLeave(String player);

}
