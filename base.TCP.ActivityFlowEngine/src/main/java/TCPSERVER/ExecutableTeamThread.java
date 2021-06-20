package TCPSERVER;

import eapli.base.catalogmanagement.domain.*;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

import java.util.*;
import java.util.concurrent.Semaphore;

public class ExecutableTeamThread implements Runnable {

    private Team team;
    private Semaphore semaphore;
    private CatalogRepository catalogRepository;
    private ServiceRepository serviceRepository;
    private ManualTaskRepository manualTaskRepository;
    private Set<Catalog> finishedCatalogs;

    public ExecutableTeamThread(Team team, Semaphore semaphore, Set<Catalog> finishedCatalogs) {
        this.team = team;
        this.semaphore=semaphore;
        this.catalogRepository = PersistenceContext.repositories().catalogs();
        this.serviceRepository = PersistenceContext.repositories().services();
        this.manualTaskRepository = PersistenceContext.repositories().manualTasks();
        this.finishedCatalogs = finishedCatalogs;
    }

    @Override
    public void run() {
        Set<Catalog> finishedCatalogs = new HashSet<>();

        Iterable<Catalog> catalogsByTeam = catalogRepository.findByTeams(this.team);
        Iterator<Catalog> iterator = catalogsByTeam.iterator();
        Set<ClientUser> lstClientsByTeam = this.team.collaboratorList();
        List<ClientUser> lstClients = convertSetClientsInList(lstClientsByTeam);
        int i = 0;
        int j = 100;
        while (iterator.hasNext()) {
            Catalog c = iterator.next();
            if(!this.finishedCatalogs.contains(c)){
                for (Service s : serviceRepository.findByCatalog(c)) {
                    for (Sequence sequence : s.workflow().Sequences()) {
                        Task task = sequence.tasks();
                        if (manualTaskRepository.containsOfIdentity(task.identity())){
                            ManualTask manual = manualTaskRepository.ofIdentity(task.identity()).get();
                            manual.setResponsable(new Responsable(Long.valueOf(String.valueOf(j)), lstClients.get(i),new Delegaction(Long.valueOf(String.valueOf(j)), Description.valueOf("Justificacao"), Designation.valueOf("Alternativa")), this.team));
                            manualTaskRepository.save(manual);
                        }
                    }

                }
                if (i == lstClientsByTeam.size()) {
                    i = 0;
                    j++;
                }else {
                    i++;
                    j++;
                }
            }

        }

        semaphore.release();
    }

    private List<ClientUser> convertSetClientsInList(Set<ClientUser> lstClientsByTeam) {
        Iterator<ClientUser> it = lstClientsByTeam.iterator();
        List<ClientUser> lst = new ArrayList<>();
        while (it.hasNext()) {
            lst.add(it.next());
        }
        return lst;
    }

}
