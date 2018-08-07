package me.david.werwolf;


import lombok.Getter;
import me.david.werwolf.game.Game;

import java.util.HashMap;
import java.util.Map;

public class WerWolf {

    @Getter private Map<String, Game> games = new HashMap<>();

}
