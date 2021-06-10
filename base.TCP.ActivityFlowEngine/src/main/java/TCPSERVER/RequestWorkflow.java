package TCPSERVER;

import eapli.base.catalogmanagement.application.SearchWorkflowService;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;

public class RequestWorkflow {
    private SearchWorkflowService searchWorkflowService;

    public RequestWorkflow() {
        this.searchWorkflowService = new SearchWorkflowService();
    }

    public void createWorkflowPedido(String idPedido, String idservice){
        Preconditions.noneNull(idPedido, idservice);
         Workflow workflow= searchWorkflowService.getWorkflowByService(22l);
        System.out.println(workflow.toString());

    }
}
