package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.Draft;
import eapli.base.ordermanagement.repository.DraftRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

class JpaDraftRepository extends JpaAutoTxRepository<Draft, Long, Long> implements DraftRepository {

    public JpaDraftRepository(final TransactionalContext autoTx){
        super(autoTx,"identifier");
    }

    public JpaDraftRepository(String name){
        super(name, Application.settings().getExtendedPersistenceProperties(),"identifier");
    }

    public JpaDraftRepository(){
        super("identifier", Application.settings().getExtendedPersistenceProperties(),"identifier");
    }


}