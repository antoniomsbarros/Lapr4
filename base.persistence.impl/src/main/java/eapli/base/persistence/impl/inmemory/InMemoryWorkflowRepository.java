package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.WorkflowRepository;
import eapli.base.ordermanagement.domain.Request;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryWorkflowRepository extends InMemoryDomainRepository<Workflow,Long> implements WorkflowRepository {
    @Override
    public Iterable<Sequence> getsequencesbyWorkflow(Long id_workflow) {
        return null;
        ///return match(e -> e.identity().equals(id_workflow));
    }

}
