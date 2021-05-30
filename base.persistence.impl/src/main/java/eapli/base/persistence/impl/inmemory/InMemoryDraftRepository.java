package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.Draft;
import eapli.base.ordermanagement.repository.DraftRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryDraftRepository extends InMemoryDomainRepository<Draft,Long> implements DraftRepository {
    static {
        InMemoryInitializer.init();
    }
}
