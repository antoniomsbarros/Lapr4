package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.CollaboratorEmail;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SearchCollaboratorController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final ClientUserRepository repo = PersistenceContext.repositories().clientUsers();

    public ClientUser getCollaboratorbyUsername(String username){
        CollaboratorEmail collaboratorEmail=new CollaboratorEmail(username);
       return repo.getClientUserByEmail(collaboratorEmail).get();
    }
}
