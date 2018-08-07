package me.david.werwolf.task;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskManager {

    @Getter private static TaskManager instance = new TaskManager();

    @Getter private Set<Task> tasks = new HashSet<>();
    @Getter private TaskThread taskThread = new TaskThread();
    @Getter private Executor threadExecutor = Executors.newFixedThreadPool(2);

    private TaskManager() {
        taskThread.start();
    }

    public void registerTask(Task task) {
        tasks.add(task);
    }

}
