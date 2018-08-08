package me.david.werwolf.game.database;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class AsyncDatabaseConnection {

    private DatabaseConnection connection;
    private ExecutorService executor = Executors.newCachedThreadPool();

    public AsyncDatabaseConnection(DatabaseConnection connection) {
        this.connection = connection;
    }

    public void createUser(UserDatabaseObject user, Runnable runnable) {
        executor.submit(() -> {
            connection.createUser(user);
            runnable.run();
        });
    }

    public void getUser(String email, Consumer<UserDatabaseObject> consumer) {
        executor.submit(() -> consumer.accept(connection.getUser(email)));
    }
}
