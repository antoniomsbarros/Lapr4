package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Criticalitylevel;
import eapli.base.catalogmanagement.repository.CriticalityLevelRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCriticalitylevelRepository extends JpaAutoTxRepository<Criticalitylevel, Long, Long> implements CriticalityLevelRepository {

    public JpaCriticalitylevelRepository(final TransactionalContext autoTx){
        super(autoTx,"id");
    }

    public JpaCriticalitylevelRepository(String name){
        super(name, Application.settings().getExtendedPersistenceProperties(),"id");
    }

    public JpaCriticalitylevelRepository(){
        super("id", Application.settings().getExtendedPersistenceProperties(),"id");
    }
}
