package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.SequenceRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemorySequenceRepository extends InMemoryDomainRepository<Sequence, Long> implements SequenceRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Sequence> findSequencesbyWorkflow(Workflow workflow) {
       throw new UnsupportedOperationException("NOT IMPLEMENTED YET");
    }
}
