package eapli.base.taskmanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.taskmanagement.domain.*;
import eapli.base.taskmanagement.repositories.AutomaticTaskRepository;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.base.teamManagement.domain.TeamType;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;
import java.util.Set;

public class AddManualTaskController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ManualTaskRepository manualTaskRepository = PersistenceContext.repositories().manualTasks();

    public void addManualTask(Calendar deadline, Integer priority,
                                 ClientUser collaborator, Set<Attribute>commentaryList, Set<Attribute>decisionList ) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.GSH_MANAGER);

        try {
            final ManualTask manualTask = new ManualTask(TaskType.UNKNOWN, TaskState.PENDING, new Deadline(deadline),
                                                         priority,collaborator,commentaryList,decisionList);

            manualTaskRepository.save(manualTask);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("\nAutomaticTask saved!");

    }
}
