package eapli.base.catalogmanagement.repository;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.Optional;

public interface CatalogRepository extends DomainRepository<Long, Catalog> {

    Iterable<Catalog> getAllCatalogs();

    default Optional<Catalog> findByIdentifier(Long number) {
        return ofIdentity(number);
    }
}
