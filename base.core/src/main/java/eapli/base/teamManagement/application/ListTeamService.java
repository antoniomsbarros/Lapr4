package eapli.base.teamManagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.dto.ClientUserDTO;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.dto.TeamDTO;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author marly
 */
public class ListTeamService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeamRepository teamRepository = PersistenceContext.repositories().team();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();

    public Iterable<TeamDTO> teams(){
      //  authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MENU_MANAGER);

        Iterable<Team> teams = teamRepository.findAll();
        List<TeamDTO> teamsDTO = new ArrayList<>();

        for (Team t: teams) {
                teamsDTO.add(t.toDTO());
            }

        return teamsDTO;
    }

    public Iterable<TeamDTO> teamListWithoutThisCollaborrator(MecanographicNumber collaboratorId){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.RRH_MANAGER);

        Iterable<Team> teams = teamRepository.findAll();
        Optional<ClientUser> collaborator = clientUserRepository.findByMecanographicNumber(collaboratorId);
        List<TeamDTO> teamsDTO = new ArrayList<>();

        if (collaborator.isPresent()) {
            for (Team t : teams) {
                if (!t.exist(collaborator.get())) {
                    teamsDTO.add(t.toDTO());
                }
            }
        }
        else {
            teamsDTO = null;
        }
            return teamsDTO;
    }

    public Iterable<ClientUserDTO> teamCollaborators(Uniquecode uniquecode) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER,
                BaseRoles.RRH_MANAGER);

        Optional<Team> team = teamRepository.ofIdentity(uniquecode);
        List<ClientUserDTO> clientUserDTO = new ArrayList<>();

        if (team.isPresent()) {
            for (ClientUser clientUser : team.get().collaboratorList()) {
                clientUserDTO.add(clientUser.toDTO());
            }
        }
        return clientUserDTO;
    }

}
