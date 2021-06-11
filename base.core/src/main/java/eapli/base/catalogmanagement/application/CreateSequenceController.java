package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.SequenceBuilder;
import eapli.base.catalogmanagement.repository.SequenceRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class CreateSequenceController {
    private final AuthorizationService authz;
    private final SequenceRepository sequenceRepository;
    private final SequenceBuilder sequenceBuilder;
    public CreateSequenceController() {
        this.authz = AuthzRegistry.authorizationService();;
        this.sequenceRepository = PersistenceContext.repositories().sequences();
        this.sequenceBuilder=new SequenceBuilder();
    }

    public Sequence createSequence(Task task, Long position){
        sequenceBuilder.withPosition(position).withTask(task);
        return sequenceRepository.save(sequenceBuilder.build());
    }
}
