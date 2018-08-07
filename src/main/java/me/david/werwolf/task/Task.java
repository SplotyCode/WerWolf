package me.david.werwolf.task;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class Task {

    @Getter private final boolean async;
    @Getter private final Runnable runnable;

    abstract boolean isReady();

    abstract void onCall();

}
