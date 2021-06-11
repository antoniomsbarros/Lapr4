package TCPSERVER;

import eapli.base.catalogmanagement.application.CreateSequenceController;
import eapli.base.catalogmanagement.application.CreateWorkflow;
import eapli.base.catalogmanagement.application.SearchWorkflowService;
import eapli.base.catalogmanagement.application.SequenceController;
import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.taskmanagement.application.AddAutomaticTaskController;
import eapli.base.taskmanagement.application.AddManualTaskController;
import eapli.base.taskmanagement.application.SearchAutomaticTask;
import eapli.base.taskmanagement.application.SearchManualTask;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;
import java.util.*;

public class RequestWorkflow {
    private SearchWorkflowService searchWorkflowService;
    private SequenceController sequenceController;
    private SearchManualTask searchManualTask;
    private SearchAutomaticTask searchAutomaticTask;
    private CreateWorkflow createWorkflow;
    private AddAutomaticTaskController addAutomaticTaskController;
    private AddManualTaskController addManualTaskController;
    public RequestWorkflow() {
        this.searchWorkflowService = new SearchWorkflowService();
        this.sequenceController=new SequenceController();
        searchManualTask=new SearchManualTask();
        searchAutomaticTask=new SearchAutomaticTask();
        createWorkflow=new CreateWorkflow();
        addAutomaticTaskController=new AddAutomaticTaskController();
        addManualTaskController=new AddManualTaskController();
    }

    public void createWorkflowPedido(String idPedido, String idservice){
        Preconditions.noneNull(idPedido, idservice);
         Workflow workflow= searchWorkflowService.getWorkflowByService(22l);

        Map<Integer, AutomaticTask> tasks=new HashMap<>();
        Map<Integer, ManualTask> manualTasks=new HashMap<>();
        System.out.println(workflow.Sequences().size());
        for (int i = 0; i < workflow.Sequences().size(); i++) {
            try {
                AutomaticTask automaticTask= searchAutomaticTask.automaticTaskbyid(workflow.Sequences().get(i).tasks().identity());
                tasks.put(i,automaticTask);
            }catch (NoSuchElementException e){
                ManualTask manualTask= searchManualTask.getmanualtask(workflow.Sequences().get(i).tasks().identity());
                manualTasks.put(i, manualTask);
            }
        }


        CreateSequenceController sequenceController=new CreateSequenceController();
        System.out.println(sequenceController.createSequence(manualTasks.get(0),1L).toString());
        List<Sequence> sequences=new LinkedList<>();
        sequences.add(sequenceController.createSequence(manualTasks.get(0),1L));
        System.out.println(createWorkflow.createWorkflow(sequences).toString());
        System.out.println(tasks.size()+" AutomaticTask");
        System.out.println(manualTasks.size()+" ManualTask");
        int size=tasks.size()+ manualTasks.size();
        for (int i = 0; i <size ; i++) {
            if (manualTasks.containsKey(i)){

                //ManualTask manualTask=addManualTaskController.addManualTask();

            }else if (tasks.containsKey(i)){



            }
        }
    }

}
