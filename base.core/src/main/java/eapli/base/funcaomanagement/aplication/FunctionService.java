package eapli.base.funcaomanagement.aplication;

import eapli.base.funcaomanagement.domain.Function;
import eapli.base.funcaomanagement.dto.FunctionDTO;
import eapli.base.funcaomanagement.repositories.FunctionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.dto.TeamDTO;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author marly
 */
public class FunctionService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final FunctionRepository functionRepository = PersistenceContext.repositories().functions();
    private List<FunctionDTO> functionDTO;

    public Iterable<Function> functions(){

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.RRH_MANAGER, BaseRoles.ADMIN);

        return functionRepository.activeFunctions();
    }

    public Optional<Function> findbyID(final Long functionCode) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER,
                BaseRoles.RRH_MANAGER, BaseRoles.ADMIN);

        return functionRepository.ofIdentity(functionCode);
    }

    public Optional<Function> findbyName(final Designation functionName) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER,
                BaseRoles.RRH_MANAGER, BaseRoles.ADMIN);

        return functionRepository.findFunctionbyName(functionName);
    }
}
