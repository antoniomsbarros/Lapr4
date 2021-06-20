package TCPSERVER;

import eapli.base.taskmanagement.domain.AutomaticTask;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class SegundAlgoritm {
    private  Thread[] threads;
    private int numberthreads=5;
    private static   LinkedList<AutomaticTask> automaticTasks=new LinkedList<>();
    private Map<Integer, List<AutomaticTask>> aut=new HashMap<>();

    public void Segundalgoritm(List<AutomaticTask> automaticTaskList){

        for (int i = 0; i < 5; i++) {
            aut.put(i, new LinkedList<AutomaticTask>());
            threads[i]=new Thread(new TcpSrvRunThread((LinkedList<AutomaticTask>) aut.get(i)));

        }

        for (AutomaticTask a:automaticTaskList) {
            for (int i = 0; i < i; i++) {

            }
        }


    }
    class TcpSrvRunThread implements Runnable{
        private LinkedList<AutomaticTask> automaticTasks;

        public TcpSrvRunThread(LinkedList<AutomaticTask> automaticTasks) {
            this.automaticTasks = automaticTasks;
        }

        public synchronized  void addList(AutomaticTask automaticTask){
            automaticTasks.add(automaticTask);
        }
        public synchronized void remove(){
            automaticTasks.remove();
        }
        public synchronized int size(){
            return automaticTasks.size();
        }

        @Override
        public void run() {
            remove();
        }
    }


}
