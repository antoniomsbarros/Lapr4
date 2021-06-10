package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.SequenceRepository;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.catalogmanagement.repository.WorkflowRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class SequenceController {
    private final AuthorizationService authz;
    private final SequenceRepository sequenceRepository;
    public SequenceController() {
        this.authz =  AuthzRegistry.authorizationService();
        this.sequenceRepository=PersistenceContext.repositories().sequences();
    }
    public List<Sequence> sequencesoftheWorkflow(Workflow workflow){
        return (List<Sequence>) sequenceRepository.findSequencesbyWorkflow(workflow);
    }
}
