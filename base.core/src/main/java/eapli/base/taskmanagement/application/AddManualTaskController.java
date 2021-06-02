package eapli.base.taskmanagement.application;

import eapli.base.catalogmanagement.domain.Responsable;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.domain.*;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;


public class AddManualTaskController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ManualTaskRepository manualTaskRepository = PersistenceContext.repositories().manualTasks();
    private final TeamRepository teamRepository = PersistenceContext.repositories().team();

    public void addManualTask(Calendar deadline, Integer priority,
                              Responsable collaborator, Description commentary, Description decision ) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN,BaseRoles.GSH_MANAGER);

        try {
            final ManualTask manualTask = new ManualTask(TaskState.PENDING, new Deadline(deadline),
                                                         priority,TaskType.UNKNOWN,collaborator,commentary,decision);
            manualTaskRepository.save(manualTask);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("\nAutomaticTask saved!");

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
