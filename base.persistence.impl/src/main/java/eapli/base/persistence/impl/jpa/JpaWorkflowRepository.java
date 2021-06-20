package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.WorkflowRepository;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public Iterable<Workflow> getWorkflowByTask(final Task task) {

        final TypedQuery<Workflow> q = createQuery("SELECT w FROM Workflow w JOIN w.sequences seq " +
                        "WHERE seq.activity = :task",
                Workflow.class);
        q.setParameter("task", task);
        return q.getResultList();
    }
}
