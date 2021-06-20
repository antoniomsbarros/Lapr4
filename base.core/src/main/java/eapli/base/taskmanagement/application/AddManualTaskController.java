package eapli.base.taskmanagement.application;

import eapli.base.catalogmanagement.domain.Responsable;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.taskmanagement.domain.*;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;
import java.util.List;


public class AddManualTaskController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ManualTaskRepository manualTaskRepository = PersistenceContext.repositories().manualTasks();
    private final TeamRepository teamRepository = PersistenceContext.repositories().team();

    public ManualTask addManualTask(Deadline deadline, Integer priority,
                                    Responsable collaborator, Description commentary, Description decision, Form form, List<Answer> lstResposta ) {
        ManualTask manualTask = null;
        try {
            manualTask = new ManualTask(TaskState.PENDING, deadline, priority,
                                        TaskType.UNKNOWN,collaborator,commentary,decision, form,lstResposta);
            return manualTaskRepository.save(manualTask);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("\nManualTask saved!");
        return manualTask;
    }

    public Iterable<Team> getTeamResponsible(ClientUser c){
        Iterable<Team> teams = teamRepository.activeTeams();

        while(teams.iterator().hasNext()){
            if (teams.iterator().next().exist(c)){
                return teams;
            }
        }
        return null;
    }

    public void choosetaskType(TaskType t, ManualTask task){
            switch (t){
                case UNKNOWN:
                    break;
                default:
                    task.setType(t);
                    break;
            }
    }


}
