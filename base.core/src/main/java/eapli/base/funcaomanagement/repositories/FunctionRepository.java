package eapli.base.funcaomanagement.repositories;

import eapli.base.funcaomanagement.domain.Function;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FunctionRepository extends DomainRepository<Long, Function> {
    @Query(value = "SELECT code FROM Function WHERE code =:unicode",nativeQuery = true)
    Optional<Function> findFunctionbyID(Long uniquecode);

    public Iterable<Function> activeFunctions();
}
