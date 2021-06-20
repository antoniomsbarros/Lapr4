package eapli.base.catalogmanagement.repository;

import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface WorkflowRepository extends DomainRepository<Long, Workflow> {
    Iterable<Sequence> getsequencesbyWorkflow(Long id_workflow);

    default Optional<Workflow> findByID(Long lngID) {
        return ofIdentity(lngID);
    }
    Iterable<Workflow> getWorkflowByTask(final Task task);

    Iterable<Workflow> findAll();
}
