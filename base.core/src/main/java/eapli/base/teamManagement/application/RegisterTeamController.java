package eapli.base.teamManagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.domain.*;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.teamManagement.repositories.TeamTypeRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.validations.Preconditions;

import java.util.Set;

@UseCaseController
public class RegisterTeamController {

private TeamRepository teamRepository= PersistenceContext.repositories().team();
private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
private final TeamTypeRepository teamTypeRepository=PersistenceContext.repositories().teamTypes();
private ClientUserRepository collobaroters =PersistenceContext.repositories().clientUsers();

public Team registerTeam(final String uniquecode, final Description responsable,
                         final Description collaboratorList, final String designacaoEquipa,
                         final String acronimoEquipa, final Description teamType) {
    authorizationService.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);
    final TeamBuilder teamBuilder=new TeamBuilder();
    teamBuilder.withDesignationTeam(designacaoEquipa).withteamAcronym(acronimoEquipa).withUniqueCode(uniquecode)
            .withTeamType(teamType).withResponsable(responsable).withCollaboratorList(collaboratorList);

    return teamRepository.save(teamBuilder.build());

    }
    public Iterable<ClientUser> allColaborators(){
        return collobaroters.findAll();
    }
    public Iterable<Team> allTeams(){
        return teamRepository.findAll();
    }
    public Iterable<TeamType> allteamTypes(){
    return teamTypeRepository.findAll();
    }



}
