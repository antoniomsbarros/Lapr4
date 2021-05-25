package eapli.base.persistence.impl.inmemory;

import eapli.base.funcaomanagement.domain.Function;
import eapli.base.funcaomanagement.repositories.FunctionRepository;
import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

/**
 *
 * @author marly
 */
public class InMemoryFunctionRepository extends InMemoryDomainRepository<Function, Long>
        implements FunctionRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Function> findFunctionbyName(Designation name) {
        return Optional.of(data().get(name));
    }

    @Override
    public Iterable<Function> activeFunctions() {
        return match(Function::isActive);
    }

}
