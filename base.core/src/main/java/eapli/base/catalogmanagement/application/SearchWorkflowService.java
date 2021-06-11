package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.catalogmanagement.repository.WorkflowRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SearchWorkflowService {
    private final AuthorizationService authz;
    private final ServiceRepository serviceRepository;
    private final WorkflowRepository workflowRepository;
    public SearchWorkflowService() {
        this.authz =  AuthzRegistry.authorizationService();
        this.serviceRepository = PersistenceContext.repositories().services();
        this.workflowRepository=PersistenceContext.repositories().workflow();
    }
    public Workflow getWorkflowByService(Long id_service){
        Workflow workflow= serviceRepository.findbyidServiceworkflow(id_service).get();

        return workflow;
    }
}
