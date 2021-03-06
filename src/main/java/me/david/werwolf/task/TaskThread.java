package me.david.werwolf.task;

public class TaskThread extends Thread {

    /* Delay in ms */
    private static final long REFRESH_DELAY = 250;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (Task task : TaskManager.getInstance().getTasks()) {
            if (task.isReady()) {
                if (task.isAsync())
                    TaskManager.getInstance().getThreadExecutor().execute(task.getRunnable());
                else task.getRunnable().run();
                task.onCall();
            }
        }
        long delay = System.currentTimeMillis() - start;
        if (delay > 1200) {
            System.out.println("TaskThread is heavily overloaded! Current Delay: " + delay);
        }
        try {
            Thread.sleep(Math.max(0, REFRESH_DELAY - delay));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        run();
    }

}
