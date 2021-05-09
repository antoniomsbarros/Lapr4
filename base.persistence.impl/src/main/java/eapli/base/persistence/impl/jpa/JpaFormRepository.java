package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaFormRepository extends JpaAutoTxRepository<Form, Long, Long> implements FormRepository {

    public JpaFormRepository(final TransactionalContext autoTx){
        super(autoTx,"identifier");
    }

    public JpaFormRepository(String name){
        super(name, Application.settings().getExtendedPersistenceProperties(),"identifier");
    }

    public JpaFormRepository(){
        super("identifier", Application.settings().getExtendedPersistenceProperties(),"identifier");
    }
}
