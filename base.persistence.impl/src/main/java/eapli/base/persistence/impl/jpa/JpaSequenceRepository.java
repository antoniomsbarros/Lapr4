package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.SequenceRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;

public class  JpaSequenceRepository extends JpaAutoTxRepository<Sequence, Long, Long> implements SequenceRepository {
    public JpaSequenceRepository(final TransactionalContext autoTx){
        super(autoTx,"id");
    }

    public JpaSequenceRepository(String name){
        super(name, Application.settings().getExtendedPersistenceProperties(),"id");
    }

    public JpaSequenceRepository(){
        super("id", Application.settings().getExtendedPersistenceProperties(),"id");
    }

    @Override
    public Iterable<Sequence> findSequencesbyWorkflow(Workflow workflow) {
        final Map<String,Object> params = new HashMap<>();
        params.put("workflow", workflow);
        return match("e.workflow=:workflow",params);
    }
}
