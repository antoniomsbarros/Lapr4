package eapli.base.teamManagement.application;

import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class TeamController {

private TeamRepository teamRepository= PersistenceContext.repositories().team();
private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

private ClientUserRepository collobaroters =PersistenceContext.repositories().clientUsers();

}
