package TCPSERVER;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.domain.Team;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class FirstComeFirstServedAlgorithm {
    Semaphore sem =new Semaphore(5);
    Thread thread[];
    private Set<Catalog> finishedCatalogs = new HashSet<>();
    private final CatalogRepository catalogRepository = PersistenceContext.repositories().catalogs();


    public void firstComeFirstServed(LinkedList<Team> cliSock) throws InterruptedException {
        for (int i = 0; i < cliSock.size(); i++) {
            if (sem.availablePermits()==0){
                sem.acquire();
                sem.release();
            }else {
                sem.acquire();
                Team t = cliSock.remove();
                new Thread(new ExecutableTeamThread(t,sem, finishedCatalogs)).start();
                Iterable<Catalog> cats = catalogRepository.findByTeams(t);
                Iterator<Catalog> it = cats.iterator();
                while (it.hasNext()){
                    finishedCatalogs.add(it.next());
                }
            }
        }
    }

    public Set<Catalog> getFinishedCatalogs() {return this.finishedCatalogs;}
}
