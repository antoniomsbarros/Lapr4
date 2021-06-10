package eapli.base.catalogmanagement.repository;

import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.framework.domain.repositories.DomainRepository;

public interface WorkflowRepository extends DomainRepository<Long, Workflow> {
    Iterable<Sequence> getsequencesbyWorkflow(Long id_workflow);
    
}
