package eapli.base.funcaomanagement.repositories;

import eapli.base.funcaomanagement.domain.Function;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;
import eapli.framework.general.domain.model.Designation;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FunctionRepository extends DomainRepository<Long, Function> {
    @Query(value = "SELECT functioncode FROM Function WHERE functioncode =:unicode",nativeQuery = true)
    Optional<Function> findFunctionbyName(Designation name);
    Optional<Function> ofIdentity(Long id);
    void deleteOfIdentity(Long entityId);

    public Iterable<Function> activeFunctions();
}
