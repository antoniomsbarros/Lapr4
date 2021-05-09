package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogmanagement.domain.Criticalitylevel;
import eapli.base.catalogmanagement.repository.CriticalityLevelRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCriticalitylevelRepository extends InMemoryDomainRepository<Criticalitylevel, Long> implements CriticalityLevelRepository {
    static {
        InMemoryInitializer.init();
    }
}
