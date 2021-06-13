package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.domain.Ticket;
import eapli.base.ordermanagement.repository.TicketRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaTicketRepository extends JpaAutoTxRepository<Ticket,Long,Long> implements TicketRepository {

    public JpaTicketRepository(TransactionalContext autoTx) {
        super(autoTx, "identifier");
    }

    public JpaTicketRepository(String name) {
        super(name, Application.settings().getExtendedPersistenceProperties(), "identifier");
    }

    @Override
    public Optional<Ticket> findTicketbyRequestid(Long request_id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("request", request_id);
        return matchOne("e.request.idRequest=:request", params);
    }
}
