package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author marly
 */
public class AssociateRemoveCollaboratorTeamController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository collaboratorRepository = PersistenceContext.repositories().clientUsers();
    private final TeamRepository teamRepository = PersistenceContext.repositories().team();

    public void associateCollaboratorTeamController(){

    }

    public void removeCollaboratorTeamController(){

    }

}

