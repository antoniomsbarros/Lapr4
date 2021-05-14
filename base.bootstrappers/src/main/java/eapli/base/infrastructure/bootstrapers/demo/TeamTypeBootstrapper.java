package eapli.base.infrastructure.bootstrapers.demo;


import eapli.base.teamManagement.application.CreateTeamTypeController;
import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TeamTypeBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            TeamTypeBootstrapper.class);

    private final CreateTeamTypeController createTeamTypeController = new CreateTeamTypeController();



    @Override
    public boolean execute() {
        registerTeamType(Uniquecode.valueOf("1"),Description.valueOf("Red"), Description.valueOf("TeamType1"));
        registerTeamType(Uniquecode.valueOf("2"),Description.valueOf("Blue"), Description.valueOf("TeamType2"));
        registerTeamType(Uniquecode.valueOf("3"),Description.valueOf("Purple"), Description.valueOf("TeamType3"));
        registerTeamType(Uniquecode.valueOf("4"),Description.valueOf("Green"), Description.valueOf("TeamType4"));
        registerTeamType(Uniquecode.valueOf("5"),Description.valueOf("Yellow"), Description.valueOf("TeamType5"));

        return true;
    }

    private TeamType registerTeamType(final Uniquecode singleCode, final Description color, final Description description) {
        TeamType request = null;

        try {
            request = createTeamTypeController.registerTeamType(singleCode,color,description);

        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", description);
            LOGGER.trace("Assuming existing record", e);
        }
        return request;
    }

}