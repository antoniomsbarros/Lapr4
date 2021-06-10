package TCPSERVER;

import eapli.base.catalogmanagement.application.SearchWorkflowService;
import eapli.base.catalogmanagement.application.SequenceController;
import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.taskmanagement.application.SearchAutomaticTask;
import eapli.base.taskmanagement.application.SearchManualTask;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class RequestWorkflow {
    private SearchWorkflowService searchWorkflowService;
    private SequenceController sequenceController;
    private SearchManualTask searchManualTask;
    private SearchAutomaticTask searchAutomaticTask;
    public RequestWorkflow() {
        this.searchWorkflowService = new SearchWorkflowService();
        this.sequenceController=new SequenceController();
        searchManualTask=new SearchManualTask();
        searchAutomaticTask=new SearchAutomaticTask();
    }

    public void createWorkflowPedido(String idPedido, String idservice){
        Preconditions.noneNull(idPedido, idservice);
         Workflow workflow= searchWorkflowService.getWorkflowByService(22l);

        List<AutomaticTask> tasks=new LinkedList<>();
        List<ManualTask> manualTasks=new LinkedList<>();
        System.out.println(workflow.Sequences().size());
        for (int i = 0; i < workflow.Sequences().size(); i++) {

            try {
                AutomaticTask automaticTask= searchAutomaticTask.automaticTaskbyid(workflow.Sequences().get(i).tasks().identity());
                tasks.add(automaticTask);
            }catch (NoSuchElementException e){
                ManualTask manualTask= searchManualTask.getmanualtask(workflow.Sequences().get(i).tasks().identity());
                System.out.println(manualTask.toString());
                manualTasks.add(manualTask);
            }
        }

        System.out.println(tasks.size()+" AutomaticTask");
        System.out.println(manualTasks.size()+" ManualTask");

    }
}
