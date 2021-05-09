package eapli.base.catalogmanagement.repository;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public interface CatalogRepository extends DomainRepository<Long, Catalog> {

    Iterable<Catalog> getAllCatalogs();


}
