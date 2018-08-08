package me.david.werwolf;


import lombok.Getter;
import me.david.werwolf.game.Game;
import me.david.werwolf.game.database.AsyncDatabaseConnection;
import me.david.werwolf.game.database.DatabaseConnection;

import java.util.HashMap;
import java.util.Map;

public class WerWolf {

    @Getter private Map<String, Game> games = new HashMap<>();
    @Getter private DatabaseConnection connection = new DatabaseConnection();
    @Getter private AsyncDatabaseConnection asyncConnection = new AsyncDatabaseConnection(connection);

}
