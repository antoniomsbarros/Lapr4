package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.beans.DesignMode;
import java.util.Optional;

public class InMemoryCatalogRepository extends InMemoryDomainRepository<Catalog,Long> implements CatalogRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Catalog> getAllCatalogs() {
        return null;
    }

    @Override
    public Optional<Catalog> getCatalogByTitle(Description title) {
        return matchOne(e -> e.Title().equals(title));
    }
}
