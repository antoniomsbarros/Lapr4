package eapli.base.catalogmanagement.repository;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.framework.domain.repositories.DomainRepository;

public interface SequenceRepository extends DomainRepository<Long,Sequence> {

    Iterable<Sequence> findSequencesbyWorkflow(Workflow workflow);

}
