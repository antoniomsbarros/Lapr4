package eapli.base.persistence.impl.inmemory;

import eapli.base.funcaomanagement.domain.Function;
import eapli.base.funcaomanagement.repositories.FunctionRepository;
import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

/**
 *
 * @author marly
 */
public class InMemoryFunctionRepository extends InMemoryDomainRepository<Function, Uniquecode>
        implements FunctionRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Function> findFunctionbyID(Uniquecode uniquecode) {
        return Optional.of(data().get(uniquecode));
    }

    @Override
    public Iterable<Function> activeFunctions() {
        return match(Function::isActive);
    }

}
