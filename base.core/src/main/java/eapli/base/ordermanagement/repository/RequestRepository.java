package eapli.base.ordermanagement.repository;

import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.ordermanagement.domain.Request;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface RequestRepository extends DomainRepository<Long, Request> {

    default Optional<Request> findByID(Long lngID) {
        return ofIdentity(lngID);
    }
    Optional<Request> getRequestByWorkflow(final Workflow workflow);
    Iterable<Request> findAll();
}
