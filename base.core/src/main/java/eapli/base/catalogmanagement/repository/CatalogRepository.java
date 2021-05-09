package eapli.base.catalogmanagement.repository;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.framework.domain.repositories.DomainRepository;

import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface CatalogRepository extends DomainRepository<Long, Catalog> {

    Iterable<Catalog> getAllCatalogs();


    @Query(value = "SELECT title FROM Catalog WHERE title = :title",nativeQuery = true)
    Optional<Catalog> getCatalogByTitle(Description title);

    @Query(value = "SELECT shortdescription FROM Catalog WHERE shortdescription = :shortdescription",nativeQuery = true)
    Optional<Catalog> getCatalogByShortDescription(Description shortdescription);

    @Query(value = "SELECT longdescription FROM Catalog WHERE longdescription = :longdescription",nativeQuery = true)
    Optional<Catalog> getCatalogByLongDescription(Description longdescription);

    default Optional<Catalog> findByIdentifier(Long number) {
        return ofIdentity(number);
    }

}
