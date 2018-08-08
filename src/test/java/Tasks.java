import me.david.werwolf.task.RunLaterTask;
import me.david.werwolf.task.TaskManager;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Tasks {

    @Test
    @DisplayName("Async RunLater Task Tests")
    void asyncRunLater() {
        long start = System.currentTimeMillis();
        final boolean[] runned = {false};
        TaskManager.getInstance().registerTask(new RunLaterTask(true, () -> {
            long delay = System.currentTimeMillis() - start;
            if (delay < 2000 || delay > 3500)
                Assert.fail();
            Assert.assertEquals(Thread.currentThread(), TaskManager.getInstance().getTaskThread());
            runned[0] = true;
        }, 2000));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Task not running", runned[0]);
    }
}
