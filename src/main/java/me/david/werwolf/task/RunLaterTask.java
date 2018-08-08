package me.david.werwolf.task;

public class RunLaterTask extends Task {

    private long ready;

    public RunLaterTask(boolean async, Runnable runnable, long delay) {
        super(async, runnable);
        ready = System.currentTimeMillis() + delay;
    }

    @Override
    boolean isReady() {
        return System.currentTimeMillis() >= ready;
    }

    @Override
    void onCall() {
        TaskManager.getInstance().getTasks().remove(this);
    }
}
