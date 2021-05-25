package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.teamManagement.application.CreateTeamTypeController;
import eapli.base.teamManagement.application.RegisterTeamController;
import eapli.base.teamManagement.domain.Acronym;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class TeamBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            TeamBootstrapper.class);

    private final RegisterTeamController registerTeamController = new RegisterTeamController();


    @Override
    public boolean execute() {
        List<ClientUser> contributors=listofCollaborators();
        List<TeamType> teamTypeList=listofallTeamTypes();

        registerTeam("5", contributors.get(0), new HashSet<>(), "Melhor equipa do mundo",
                "BEM", teamTypeList.get(0));
        registerTeam("2", contributors.get(1), new HashSet<>(), "Best team forever and ever",
                "BTF", teamTypeList.get(1));
        registerTeam("3", contributors.get(2), new HashSet<>(), "Lest goo team",
                "LGT", teamTypeList.get(2));
        registerTeam("4", contributors.get(3), new HashSet<>(), "Lest goo monkey team",
                "MON", teamTypeList.get(3));
        return true;
    }


    private Team registerTeam(final String uniquecode, final ClientUser responsable, final Set<ClientUser> collaboratorList,
                              final String designacaoEquipa, final String acronimoEquipa, final TeamType teamType){
        Team team=null;
        try {
            team=registerTeamController.registerTeam(uniquecode, responsable, collaboratorList, designacaoEquipa, acronimoEquipa,teamType);
        }catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", designacaoEquipa, acronimoEquipa);
            LOGGER.trace("Assuming existing record", e);
        }
        return team;
    }

    private List<ClientUser> listofCollaborators(){
        List<ClientUser> list=new ArrayList<>();
        Iterator<ClientUser> iterator=registerTeamController.allColaborators().iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
    private List<TeamType> listofallTeamTypes(){
        List<TeamType> list=new ArrayList<>();
        Iterator<TeamType> iterator=registerTeamController.allteamTypes().iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
}
