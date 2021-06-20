package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryRequestRepository extends InMemoryDomainRepository<Request,Long> implements RequestRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Request> getRequestByWorkflow(final Workflow workflow) {
        return null;
    }
}
