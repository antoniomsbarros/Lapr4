package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.domain.Ticket;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SearchRequestController {
    private RequestRepository requestRepository;
    private  final AuthorizationService authz;


    public SearchRequestController() {
        this.requestRepository = PersistenceContext.repositories().requests();
        this.authz= AuthzRegistry.authorizationService();
    }

    public Request getrequestbyid(Long requestid){
        return  requestRepository.findByID(requestid).get();
    }
}
