package eapli.base.catalogmanagement.repository;

import eapli.base.catalogmanagement.domain.Service;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ServiceRepository extends DomainRepository<Long, Service> {

    default Optional<Service> findByID(Long lngID) {
        return ofIdentity(lngID);
    }
}
