package eapli.base.funcaomanagement.aplication;

import eapli.base.funcaomanagement.domain.Function;
import eapli.base.funcaomanagement.domain.FunctionBuilder;
import eapli.base.funcaomanagement.repositories.FunctionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;
//import sun.security.krb5.internal.crypto.Des;

/**
 *
 * @author marly
 */
public class AddFunctionController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final FunctionRepository functionRepository = PersistenceContext.repositories().functions();
    private final FunctionService functionService = new FunctionService();

    public void addFunction(final Designation designation, final Description description) throws IllegalAccessException {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN,
                BaseRoles.RRH_MANAGER);

        Optional<Function> optionalFunction = functionService.findbyName(designation);

        if (optionalFunction.isPresent()){
            throw new IllegalAccessException("ERROR: Function already exist!");
        }

        final FunctionBuilder functionBuilder = new FunctionBuilder();

        functionBuilder.withFunctionName(designation).withFunctionDescription(description);

        functionRepository.save(functionBuilder.build());
        System.out.println("\nFunction saved!");
    }

    public Iterable<Function> allFunctions(){ return  functionRepository.activeFunctions();}

}
