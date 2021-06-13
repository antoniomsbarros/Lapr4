package eapli.base.ordermanagement.repository;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.ordermanagement.domain.Ticket;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface TicketRepository extends DomainRepository<Long, Ticket> {
    default Optional<Ticket> findByIdentifier(Long identifier) {
        return ofIdentity(identifier);
    }

    Optional<Ticket> findTicketbyRequestid(Long request_id);
}
