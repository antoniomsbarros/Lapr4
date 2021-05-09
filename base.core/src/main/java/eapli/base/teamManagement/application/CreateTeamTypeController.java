package eapli.base.teamManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.TeamTypeBuilder;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.repositories.TeamTypeRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class CreateTeamTypeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    private final TeamTypeRepository teamTypeRepository = PersistenceContext
            .repositories().teamTypes();

    public TeamType registerTeamType(String singleInternCode, Description color, Description description) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.RRH_MANAGER);

        final TeamTypeBuilder teamTypeBuilder = new TeamTypeBuilder();

        teamTypeBuilder.withUniqueCode(singleInternCode).withDescription(color).withColor(description);


        return teamTypeRepository.save(teamTypeBuilder.build());
    }
}
