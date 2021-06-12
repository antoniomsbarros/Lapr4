package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.domain.State;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ChangeStatusRequest {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private RequestRepository requestRepository= PersistenceContext.repositories().requests();

    public void changeStatusofRequest(Request request, State state){
        if (request==null){
            throw new IllegalArgumentException();
        }
        request.changeState(state);
    }

}
