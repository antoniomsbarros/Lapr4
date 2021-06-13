package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

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

}
