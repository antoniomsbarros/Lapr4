package eapli.base.infrastructure.bootstrapers.demo;


import eapli.base.clientusermanagement.domain.ClientUser;

import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import eapli.base.teamManagement.application.RegisterTeamController;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.TeamType;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.framework.actions.Action;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CreateTeamBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            CreateTeamBootstrapper.class);

    private final RegisterTeamController registerTeamController = new RegisterTeamController();
    private final ClientUserRepository clientUserRepository =
            PersistenceContext.repositories().clientUsers();





    @Override
    public boolean execute() {
        Iterable<ClientUser> users = clientUserRepository.findAllActive();
        Set<ClientUser> collaborators = new HashSet<>();
        Iterator<ClientUser> usersIterator = users.iterator();
        ClientUser responsable = null;
        while(usersIterator.hasNext()){
            ClientUser user = usersIterator.next();
            if(collaborators.size() <= 3) {
                collaborators.add(user);
            }

            if(collaborators.size() == 3){
                responsable = user;
            }
        }

        Iterable<TeamType> teamTypeIterable = registerTeamController.allteamTypes();
        Iterator<TeamType> teamTypes = teamTypeIterable.iterator();

        TeamType tp1 = null;





        while(teamTypes.hasNext()) {
                tp1 = teamTypes.next();
        }



        registerTeam("1", responsable, collaborators,"Team1", "T1",tp1);
      // registerTeam("2", responsable, collaborators,"Team2", "T2" ,tp1);
       // registerTeam("3", responsable, collaborators,"Team3", "T3" ,tp3);



        return true;
    }

    private Team registerTeam(final String uniquecode, final ClientUser responsable,
                                   final Set<ClientUser> collaboratorList, final String designacaoEquipa,
                                   final String acronimoEquipa, final TeamType teamType) {
        Team request = null;

        try {
            request = registerTeamController.registerTeam(uniquecode, responsable, collaboratorList, designacaoEquipa,
                                            acronimoEquipa, teamType);

        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", designacaoEquipa);
            LOGGER.trace("Assuming existing record", e);
        }
        return request;
    }

}
