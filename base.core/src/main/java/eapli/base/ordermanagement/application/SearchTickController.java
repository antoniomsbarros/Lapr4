package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Ticket;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.base.ordermanagement.repository.TicketRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SearchTickController {
    private TicketRepository ticketRepository;
    private  final AuthorizationService authz;

    public SearchTickController() {
        this.ticketRepository = PersistenceContext.repositories().ticket();
        this.authz = AuthzRegistry.authorizationService();
    }
    public Ticket searchTickbyRequestid(Long request_id){
        return ticketRepository.findTicketbyRequestid(request_id).get();
    }
}
