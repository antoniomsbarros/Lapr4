package eapli.base.taskmanagement.application;

import eapli.base.funcaomanagement.domain.Function;
import eapli.base.funcaomanagement.domain.FunctionBuilder;
import eapli.base.funcaomanagement.repositories.FunctionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.Deadline;
import eapli.base.taskmanagement.domain.TaskState;
import eapli.base.taskmanagement.repositories.AutomaticTaskRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;
import java.util.Optional;

/**
 *
 * @author marly
 */
public class AddAutomaticTaskController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AutomaticTaskRepository automaticTaskRepository = PersistenceContext.repositories().AutomaticTasks();

    public AutomaticTask addAutomaticTask(Calendar deadline, Integer priority, String scriptPath) {


        AutomaticTask task = new AutomaticTask();
    try{
        final AutomaticTask automaticTask = new AutomaticTask(TaskState.PENDING, new Deadline(deadline), priority, Description.valueOf(scriptPath));
        task= automaticTaskRepository.save(automaticTask);
        System.out.println("AUTO TASK: " + task.toString());
    }catch (IllegalArgumentException e){
        System.out.println(e);
    }

        System.out.println("\nAutomaticTask saved!");
    return task;
    }
}
