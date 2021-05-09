package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryServiceRepository extends InMemoryDomainRepository<Service,Long> implements ServiceRepository {

    static {
        InMemoryInitializer.init();
    }

    public Optional<Service> findByID(Long number) {
        return Optional.of(data().get(number));
    }

}
