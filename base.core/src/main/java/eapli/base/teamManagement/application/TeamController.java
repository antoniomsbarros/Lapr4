package eapli.base.teamManagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.domain.Acronym;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.teamManagement.repositories.TeamTypeRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.validations.Preconditions;

import java.util.Set;

@UseCaseController
public class TeamController {

private TeamRepository teamRepository= PersistenceContext.repositories().team();
private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
private final TeamTypeRepository teamTypeRepository=PersistenceContext.repositories().teamTypes();
private ClientUserRepository collobaroters =PersistenceContext.repositories().clientUsers();

public Team registerTeam(final Uniquecode uniquecode, final ClientUser responsable,
                         final Set<ClientUser> collaboratorList, final Designation designacaoEquipa,
                         final Acronym acronimoEquipa, final TeamType teamType) {

    authorizationService.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.RRH_MANAGER);
    final Team newTeam=new Team(uniquecode, responsable,collaboratorList, designacaoEquipa, acronimoEquipa, teamType);
    return teamRepository.save(newTeam);

    }
}
