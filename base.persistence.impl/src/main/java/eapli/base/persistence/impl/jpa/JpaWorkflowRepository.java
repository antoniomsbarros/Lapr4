package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.WorkflowRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Map;

public class JpaWorkflowRepository extends JpaAutoTxRepository<Workflow, Long, Long> implements WorkflowRepository {

    public JpaWorkflowRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaWorkflowRepository(String name) {
        super(name, Application.settings().getExtendedPersistenceProperties(),"id");
    }

    public JpaWorkflowRepository() {
        super("id", Application.settings().getExtendedPersistenceProperties(),"id");
    }

    @Override
    public Iterable<Sequence> getsequencesbyWorkflow(Long id_workflow) {
        return null;
    }
}
