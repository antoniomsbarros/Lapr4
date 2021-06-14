package eapli.base.taskmanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.CollaboratorEmail;
import eapli.base.clientusermanagement.dto.ClientUserDTO;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.*;

/**
 *
 * @author marly
 */
public class ManualTaskToClaimController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ManualTaskRepository manualTaskRepository = PersistenceContext.repositories().manualTasks();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();
    private final TeamRepository teamRepository = PersistenceContext.repositories().team();
    private Optional<ClientUser> collaborator;
    private Iterable<Team> teams;
    private List<ManualTask> manualTaskIterable = new ArrayList<>();


    public Iterable<ManualTask> manualTaskToClaimList(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.COLLABORATOR);
        SystemUser systemUser = authz.session().get().authenticatedUser();
        collaborator = clientUserRepository.getClientUserByEmail(new CollaboratorEmail(systemUser.email().toString()));
        if (collaborator.isPresent()){
            teams = teamRepository.collaboratorTeams(collaborator.get().mecanographicNumber());
            for (Team team: teams) {
                manualTaskIterable.addAll((Collection<? extends ManualTask>) manualTaskRepository.manualTaskToClaim(team));
            }
        }
        else {
            throw new IllegalArgumentException("You are not a collaborator");
        }
        return manualTaskIterable;
    }

    public void claim(ManualTask manualTask){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.COLLABORATOR);
        Optional<ManualTask> optionalManualTask = manualTaskRepository.findByID(manualTask.identity());
        if (optionalManualTask.isPresent()){
            if (collaborator.isPresent()){
                manualTask.Responsible().claim(collaborator.get());;
                manualTaskRepository.save(manualTask);
            } else {
                throw new IllegalArgumentException("There is no collaborator");
            }
        }else {
            throw new IllegalArgumentException("This Manual Task does not exist in the database");
        }


    }

}
