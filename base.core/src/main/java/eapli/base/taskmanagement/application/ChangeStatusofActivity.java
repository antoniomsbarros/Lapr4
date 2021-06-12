package eapli.base.taskmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.domain.TaskState;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ChangeStatusofActivity {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private TaskRepository taskRepository= PersistenceContext.repositories().Task();


    public Task changeStatsTask(Task task, TaskState taskState){
        if (task==null){
            throw new IllegalArgumentException();
        }
        task.changeStatus(taskState);
        return taskRepository.save(task);
    }


}
