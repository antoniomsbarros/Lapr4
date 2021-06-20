package TCPSERVER;

import eapli.base.taskmanagement.domain.AutomaticTask;

import java.util.List;
import java.util.concurrent.Semaphore;

public class SegundAlgoritm {
    private final Thread[] threads;

    public SegundAlgoritm(Thread[] threads) {
        this.threads = threads;
    }
    Semaphore semaphore=new Semaphore(5);
    public void Segundalgoritm(List<AutomaticTask> automaticTaskList){


    }


}
