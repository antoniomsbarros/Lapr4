package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.domain.State;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPendentRequestByHistoryUI extends AbstractUI {

    private RequestRepository requestRepository ;

    public SortPendentRequestByHistoryUI() {
        this.requestRepository = PersistenceContext.repositories().requests();;
    }

    @Override
    protected boolean doShow() {
        List<Request> listaPedidosPendentesPorData = showSortedPendingRequest();

        for (Request r: listaPedidosPendentesPorData){
            System.out.println(r.toString());
            return true;
        }
        return false;
    }

    @Override
    public String headline() {
        return "Show Pendent Request By History";
    }

    private List<Request> showSortedPendingRequest(){
        List<Request> pendentRequests = new ArrayList<>();

        Iterable<Request> requestIterable = requestRepository.findAll();

        while(requestIterable.iterator().hasNext()){
            if (requestIterable.iterator().next().getStateofPendentResquest().equals(State.EMAPROVACAO)){
                    pendentRequests.add(requestIterable.iterator().next());
            }
        }

        Collections.sort(pendentRequests,(o1,o2)->o2.getDateofRequest().compareTo(o1.getDateofRequest()));

            return pendentRequests;
    }
}
