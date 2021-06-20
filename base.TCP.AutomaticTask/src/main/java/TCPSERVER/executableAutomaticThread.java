package TCPSERVER;

import eapli.base.taskmanagement.domain.AutomaticTask;

import java.util.List;
import java.util.concurrent.Semaphore;

public class executableAutomaticThread implements Runnable{
    private AutomaticTask automaticTask;
    private Semaphore semaphore;
    private List<AutomaticTask> automaticTasks;
    ShareObject shareObject;
    public executableAutomaticThread(AutomaticTask automaticTask, Semaphore semaphore) {
        this.automaticTask = automaticTask;
        this.semaphore=semaphore;

    }

    @Override
    public void run() {

        semaphore.release();
    }
}
