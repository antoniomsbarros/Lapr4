package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.SequenceRepository;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.catalogmanagement.repository.WorkflowRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SequenceAddToWorkflow {
    private final AuthorizationService authz;
    private final WorkflowRepository workflowRepository;

    public SequenceAddToWorkflow() {
        this.authz = AuthzRegistry.authorizationService();;
        this.workflowRepository = PersistenceContext.repositories().workflow();
    }

    public Workflow addSequencesToWorkflow(Workflow workflow, Sequence sequencetoadd){
            if (sequencetoadd==null){
                return workflow;
            }
            workflow.Sequences().add(sequencetoadd);
            return this.workflowRepository.save(workflow);
    }
}
