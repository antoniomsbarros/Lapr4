package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.dto.ClientUserDTO;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import eapli.base.teamManagement.application.TeamService;
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
public class AssociateRemoveCollaboratorTeamController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository collaboratorRepository = PersistenceContext.repositories().clientUsers();
    private final TeamRepository teamRepository = PersistenceContext.repositories().team();
    private final ClientUserService collaborators =  new ClientUserService();
    private final TeamService teams = new TeamService();

    public void associateCollaboratorTeamController(String collaboratorID, String teamID) throws IllegalAccessException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER,
                BaseRoles.RRH_MANAGER);

        Optional<ClientUser> collaborator = collaboratorRepository.findByMecanographicNumber(new MecanographicNumber(collaboratorID));
        Optional<Team> team = teams.findbyID(new Uniquecode(teamID));

        if (collaborator.isPresent() && team.isPresent()){
            if ((teams.belongToThisTeamType(team.get(), collaborator.get().mecanographicNumber()))){
                throw new IllegalArgumentException("Collaborator already belongs to this team type");
            }
            else {
                team.get().collaboratorList().add(collaborator.get());
                teamRepository.save(team.get());
            }
        }
        else {
            throw new IllegalAccessException("Collaborator or Team does not exist!");
        }

    }

    public void removeCollaboratorTeamController(String collaboratorID, String teamID) throws IllegalAccessException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER,
                BaseRoles.RRH_MANAGER);

        Optional<ClientUser> collaborator = collaboratorRepository.findByMecanographicNumber(new MecanographicNumber(collaboratorID));
        Optional<Team> team = teams.findbyID(new Uniquecode(teamID));

        if (collaborator.isPresent() && team.isPresent()){

            team.get().collaboratorList().remove(collaborator.get());
            if (team.get().collaboratorList().size()==0){
                System.out.println("You removed the last collaborator from the team");
            }

            teamRepository.save(team.get());

        }
        else {
            throw new IllegalAccessException("Collaborator or Team does not exist!");
        }
    }

    public Iterable<ClientUserDTO> collaboratorList(){
        return collaborators.findAllClientUser();
    }

   public Iterable<TeamDTO> teamListWithoutThisCollaborator(String collaboratorID){
        return teams.teamsWithOutThisCollaborator(new MecanographicNumber(collaboratorID));
    }

    public Iterable<TeamDTO> teamList(){
        return teams.teams();
    }

    public Iterable<TeamDTO> collaboratorTeams(String collaboratorID){
        return teams.collaboratorTeams(new MecanographicNumber(collaboratorID));
    }



    public Iterable<ClientUserDTO> collaboratorsOfTeam(String teamID) {
        Iterable<ClientUserDTO> c = null;
        try {
            c = teams.collaboratorsOfTeam(Uniquecode.valueOf(teamID));
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }

        return c;
    }
}

