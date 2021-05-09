package eapli.base.catalogmanagement.repository;

import eapli.base.catalogmanagement.domain.Service;
import eapli.framework.domain.repositories.DomainRepository;

public interface ServiceRepository extends DomainRepository<Long, Service> {

    Service save(Service service);
}
