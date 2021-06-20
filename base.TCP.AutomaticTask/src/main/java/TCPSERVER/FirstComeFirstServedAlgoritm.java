package TCPSERVER;

import eapli.base.taskmanagement.domain.AutomaticTask;

import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class FirstComeFirstServedAlgoritm {
    Semaphore sem =new Semaphore(5);
    Thread thread[];
public void firstComeFirstServerd(LinkedList<AutomaticTask> cliSock) throws InterruptedException {
    for (int i = 0; i < cliSock.size(); i++) {
        if (sem.availablePermits()==0){
            sem.acquire();
            sem.release();
        }else {
            sem.acquire();
            new Thread(new executableAutomaticThread(cliSock.remove(),sem )).start();
        }
    }
    }
}


