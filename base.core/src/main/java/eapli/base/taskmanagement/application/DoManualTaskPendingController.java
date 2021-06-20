package eapli.base.taskmanagement.application;

import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.WorkflowRepository;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.CollaboratorEmail;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.domain.TaskState;
import eapli.base.taskmanagement.domain.TaskType;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author marly
 */
public class DoManualTaskPendingController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ManualTaskRepository manualTaskRepository = PersistenceContext.repositories().manualTasks();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();
    private final TeamRepository teamRepository = PersistenceContext.repositories().team();
    private final WorkflowRepository workflowRepository = PersistenceContext.repositories().workflow();
    private final RequestRepository requestRepository = PersistenceContext.repositories().requests();
    private Iterable<Team> teams;
    private List<ManualTask> manualTaskIterable = new ArrayList<>();

    public Iterable<ManualTask> manualTaskPendingList(TaskType taskType){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.COLLABORATOR);
        SystemUser systemUser = authz.session().get().authenticatedUser();
        Optional<ClientUser> collaborator = clientUserRepository.getClientUserByEmail(
                new CollaboratorEmail(systemUser.email().toString()));

        if (collaborator.isPresent()){
            if (taskType == TaskType.APPROVAL){
                manualTaskIterable.addAll((Collection<? extends ManualTask>)  manualTaskRepository.
                        manualTaskToPerform(collaborator.get(), TaskState.PENDING, taskType));
                teams = teamRepository.responsibleTeams(collaborator.get());
                for (Team team: teams) {
                    manualTaskIterable.addAll((Collection<? extends ManualTask>) manualTaskRepository.manualTaskToClaim(team));
                }
            }
            else{
                manualTaskIterable.addAll((Collection<? extends ManualTask>)  manualTaskRepository.
                        manualTaskToPerform(collaborator.get(), TaskState.PENDING, taskType));
            }
        }
        else {
            throw new IllegalArgumentException("You are not a collaborator");
        }

        return manualTaskIterable;
    }

    public Request ViewRequestAnswer(ManualTask manualTask){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.COLLABORATOR);
        Iterable<Workflow>  workflow;
        Optional<Request>  optionalRequest;

        Optional<ManualTask> optionalManualTask = manualTaskRepository.findByID(manualTask.identity());
        if (optionalManualTask.isPresent()){
            workflow = workflowRepository.getWorkflowByTask(manualTask);
            if (workflow.iterator().hasNext()){
                optionalRequest = requestRepository.getRequestByWorkflow(workflow.iterator().next());
                if (optionalRequest.isPresent()){
                    return optionalRequest.get();
                }
                else {
                    throw new IllegalArgumentException("This Workflow does not exist in any Request");
                }
            }
            else {
                throw new IllegalArgumentException("This Manual Task does not exist in any Workflow");
            }
        }else {
            throw new IllegalArgumentException("This Manual Task does not exist in the database");
        }

    }

    public void doManualTaskPending(ManualTask manualTask){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.COLLABORATOR);
        Optional<Workflow>  optionalWorkflow;
        Optional<ManualTask> optionalManualTask = manualTaskRepository.findByID(manualTask.identity());

        if (optionalManualTask.isPresent()){
            optionalManualTask.get().insertAnswers(manualTask.listRespostas());
            optionalManualTask.get().done();
            manualTaskRepository.save(optionalManualTask.get());
        }else {
            throw new IllegalArgumentException("This Manual Task does not exist in the database");
        }


    }
}
