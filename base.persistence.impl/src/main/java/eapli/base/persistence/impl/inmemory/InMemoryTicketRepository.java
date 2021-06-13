package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.Ticket;
import eapli.base.ordermanagement.repository.TicketRepository;
import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryTicketRepository extends InMemoryDomainRepository<Ticket, Long> implements TicketRepository {

    static {
        InMemoryInitializer.init();
    }


    @Override
    public Optional<Ticket> findTicketbyRequestid(Long request_id) {
        return matchOne(e -> e.request().identity().equals(request_id));
    }
}
