package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCatalogRepository extends InMemoryDomainRepository<Catalog,Long> implements CatalogRepository {

    static {
        InMemoryInitializer.init();
    }
}
