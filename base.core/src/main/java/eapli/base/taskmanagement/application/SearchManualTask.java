package eapli.base.taskmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SearchManualTask {
    private final AuthorizationService authz;
    private final ManualTaskRepository manualTaskRepository;

    public SearchManualTask() {
        this.authz = AuthzRegistry.authorizationService();
        this.manualTaskRepository = PersistenceContext.repositories().manualTasks();
    }

    public ManualTask getmanualtask(Long id){
        return manualTaskRepository.findByID(id).get();
    }
}
