package eapli.base.taskmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.repositories.AutomaticTaskRepository;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SearchAutomaticTask {
    private final AuthorizationService authz;
    private final AutomaticTaskRepository automaticTaskRepository;

    public SearchAutomaticTask() {
        this.authz = AuthzRegistry.authorizationService();
        this.automaticTaskRepository = PersistenceContext.repositories().AutomaticTasks();
    }

    public AutomaticTask automaticTaskbyid(Long id){
        return automaticTaskRepository.findByID(id).get();
    }
}
