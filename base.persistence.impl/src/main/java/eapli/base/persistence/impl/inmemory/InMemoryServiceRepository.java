package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryServiceRepository extends InMemoryDomainRepository<Service,Long> implements ServiceRepository {

    static {
        InMemoryInitializer.init();
    }

    public Optional<Service> findByID(Long number) {
        return Optional.of(data().get(number));
    }

    @Override
    public Iterable<Service> findByCatalog(Catalog catalog) {
        return match(e -> e.servicecatalog().equals(catalog));
    }

    @Override
    public Optional<Workflow> findbyidServiceworkflow(Long id_service) {
        return Optional.of(data().get(id_service).workflow());
    }

}
