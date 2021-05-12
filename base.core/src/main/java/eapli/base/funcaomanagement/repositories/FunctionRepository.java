package eapli.base.funcaomanagement.repositories;

import eapli.base.funcaomanagement.domain.Function;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;

import java.util.Optional;

public interface FunctionRepository extends DomainRepository<Uniquecode, Function>, LockableDomainRepository<Uniquecode, Function> {

    Iterable<Function> activeFunctions();
    Optional<Function> findFunctionbyID(Uniquecode uniquecode);
}
