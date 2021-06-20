package TCPSERVER;

import eapli.base.taskmanagement.application.ChangeStatusofActivity;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.TaskState;

import java.util.List;
import java.util.concurrent.Semaphore;

public class executableAutomaticThread implements Runnable{
    private AutomaticTask automaticTask;
    private Semaphore semaphore;
    private List<AutomaticTask> automaticTasks;
    private ChangeStatusofActivity changeStatusofActivity=new ChangeStatusofActivity();
    ShareObject shareObject;
    public executableAutomaticThread(AutomaticTask automaticTask, Semaphore semaphore) {
        this.automaticTask = automaticTask;
        this.semaphore=semaphore;

    }

    @Override
    public void run() {
        System.out.println(automaticTask.toString());
        changeStatusofActivity.changeStatsTask(automaticTask, TaskState.DONE );
        semaphore.release();
    }
}
