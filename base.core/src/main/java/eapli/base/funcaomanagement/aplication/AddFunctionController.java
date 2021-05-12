package eapli.base.funcaomanagement.aplication;

import eapli.base.funcaomanagement.domain.Function;
import eapli.base.funcaomanagement.repositories.FunctionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author marly
 */
public class AddFunctionController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final FunctionRepository functionRepository = PersistenceContext.repositories().functions();

    public void addFunction(final String designation, final String description) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER,
                BaseRoles.RRH_MANAGER);

        final Function function = new Function(Designation.valueOf(designation), Description.valueOf(description));

        functionRepository.save(function);

    }

}
