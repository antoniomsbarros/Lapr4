package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.dto.TeamDTO;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marly
 */
public class ListTeamService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeamRepository teamRepository = PersistenceContext.repositories().team();

    public Iterable<TeamDTO> teams(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MENU_MANAGER);

        Iterable<Team> teams = teamRepository.findAll();
        List<TeamDTO> teamsDTO = new ArrayList<>();

        for (Team t: teams) {
                teamsDTO.add(t.toDTO());
            }

        return teamsDTO;
    }

}
