package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class ListCollaboratorService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();

    public Iterable<ClientUser> allCollaborators() {
        //authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
        //        CafeteriaRoles.MENU_MANAGER);

        return this.clientUserRepository.findAll();
    }




}
