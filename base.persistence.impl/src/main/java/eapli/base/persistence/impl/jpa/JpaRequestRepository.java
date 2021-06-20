package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaRequestRepository extends JpaAutoTxRepository<Request, Long, Long> implements RequestRepository {
    public JpaRequestRepository(final TransactionalContext autoTx){
        super(autoTx,"idRequest");
    }

    public JpaRequestRepository(String name){
        super(name, Application.settings().getExtendedPersistenceProperties(),"idRequest");
    }

    public JpaRequestRepository(){
        super("idRequest", Application.settings().getExtendedPersistenceProperties(),"idRequest");
    }

    @Override
    public Optional<Request> getRequestByWorkflow(final Workflow workflow) {

        final Map<String, Object> params = new HashMap<>();
        params.put("workflow", workflow);
        return matchOne("e.workflow=:workflow", params);
    }

}
