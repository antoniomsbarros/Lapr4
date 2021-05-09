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

    /**
     * TODO: juntar ao bootstrapper a equipa,colaboradores e relação entre colaborador-equipa
     */
    // private final SpecifyCollaboratorController specifyCollaboratorController = new SpecifyCollaboratorController();
    // private final AssociateRemoveCollaboratorTeamController associateRemoveCollaboratorTeamController = new AssociateRemoveCollaboratorTeamController();
    // private final RegisterTeamController registerTeamController = new RegisterTeamController();

    @Override
    public boolean execute() {
        registerTeamType(Uniquecode.valueOf("1"),Description.valueOf("Red"), Description.valueOf("TeamType1"));
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