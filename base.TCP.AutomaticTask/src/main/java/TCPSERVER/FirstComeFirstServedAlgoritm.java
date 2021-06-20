package TCPSERVER;

import eapli.base.taskmanagement.domain.AutomaticTask;

import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class FirstComeFirstServedAlgoritm {
    Semaphore sem =new Semaphore(5);
    Thread thread[];
public void firstComeFirstServerd(List<AutomaticTask> cliSock) throws InterruptedException {
    List<AutomaticTask> automaticTasks=new LinkedList<>(cliSock);
    for (AutomaticTask automaticTask: automaticTasks) {
        if (sem.availablePermits()==0){
            sem.acquire();
            sem.release();
        }else {
            sem.acquire();
            new Thread(new executableAutomaticThread(automaticTask,sem )).start();
        }
    }
    cliSock=new LinkedList<>();
    }
}


