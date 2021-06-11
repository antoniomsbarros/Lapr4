package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.domain.WorkflowBuilder;
import eapli.base.catalogmanagement.repository.SequenceRepository;
import eapli.base.catalogmanagement.repository.WorkflowRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;


public class CreateWorkflow {
    private final AuthorizationService authz;
    private WorkflowRepository workflowRepository;
    private final WorkflowBuilder workflowBuilder;

    public CreateWorkflow() {
        this.authz = AuthzRegistry.authorizationService();
        this.workflowRepository = PersistenceContext.repositories().workflow();
        this.workflowBuilder=new WorkflowBuilder();
    }


    public Workflow createWorkflow(List<Sequence> sequences){
        workflowBuilder.withSequences(sequences);
        return workflowRepository.save(workflowBuilder.build());
    }
}
