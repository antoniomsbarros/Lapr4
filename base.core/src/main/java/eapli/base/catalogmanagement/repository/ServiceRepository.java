package eapli.base.catalogmanagement.repository;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Description;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends DomainRepository<Long, Service> {

    default Optional<Service> findByID(Long lngID) {
        return ofIdentity(lngID);
    }

    Iterable<Service> findAll();

    @Query(value = "SELECT * FROM Service WHERE catalog = :catalog ",nativeQuery = true)
    Iterable<Service> findByCatalog(Catalog catalog);

    Optional<Workflow>findbyidServiceworkflow(Long id_service);
}
