package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class EspecifyCollaboratorController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository collaboratorRepository = PersistenceContext.repositories().clientUsers();

    public void especifyCollaborator() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER,
                BaseRoles.MENU_MANAGER);

        //this.collaboratorRepository.
    }
}
