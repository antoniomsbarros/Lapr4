package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryRequestRepository extends InMemoryDomainRepository<Request,Long> implements RequestRepository {

    static {
        InMemoryInitializer.init();
    }
}
