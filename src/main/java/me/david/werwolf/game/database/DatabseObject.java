package me.david.werwolf.game.database;

import org.bson.Document;

public interface DatabseObject {

    void read(Document document);
    void write(Document document);

}
