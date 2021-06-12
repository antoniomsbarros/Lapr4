package TCPSERVER;

import eapli.base.DashboardManagement.protocol;
import eapli.base.catalogmanagement.application.CreateSequenceController;
import eapli.base.catalogmanagement.application.CreateWorkflow;
import eapli.base.catalogmanagement.application.SearchWorkflowService;
import eapli.base.catalogmanagement.application.SequenceController;
import eapli.base.catalogmanagement.domain.Responsable;
import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.taskmanagement.application.AddAutomaticTaskController;
import eapli.base.taskmanagement.application.AddManualTaskController;
import eapli.base.taskmanagement.application.SearchAutomaticTask;
import eapli.base.taskmanagement.application.SearchManualTask;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.framework.general.domain.model.Description;
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

    public void createWorkflowPedido(String idPedido){
        Preconditions.noneNull(idPedido);


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
        List<Sequence> sequences=new LinkedList<>();
        sequences.add(sequenceController.createSequence(manualTasks.get(0),1L));
        int size=tasks.size()+ manualTasks.size();
        List<Sequence> sequenceList=new LinkedList<>();
        Map<Integer, ManualTask> manualTaskrequest=new HashMap<>();
        Map<Integer, AutomaticTask> automaticTaskrequest=new HashMap<>();
        for (int i = 0; i <size ; i++) {
            if (manualTasks.containsKey(i)){
                ManualTask manualTask1=manualTasks.get(i);
                Calendar date=addDays(new Date(), 15);
                Responsable responsable=new Responsable();
                /// atribuição do responsable US 4072



               /* ManualTask manualTask=addManualTaskController.addManualTask(date, manualTask1.priority(), responsable,Description.valueOf("") , Description.valueOf(""));
                Sequence sequence= sequenceController.createSequence(manualTask, (long) i);
                sequenceList.add(sequence);
                manualTaskrequest.put(i, manualTask);*/
            }else if (tasks.containsKey(i)){
                AutomaticTask automaticTask=new AutomaticTask();
                Calendar date=addDays(new Date(), 15);
                automaticTask=addAutomaticTaskController.addAutomaticTask(date, tasks.get(i).priority(), tasks.get(i).script().toString());
                Sequence sequence=sequenceController.createSequence(automaticTask, (long) i);
                sequenceList.add(sequence);
                automaticTaskrequest.put(i,automaticTask);
            }
        }
        Workflow workflowRequest=createWorkflow.createWorkflow(sequenceList);


        for (int i = 0; i < workflowRequest.Sequences().size(); i++) {
            if (automaticTaskrequest.containsKey(i)){

            }else if (manualTaskrequest.containsKey(i)){

            }
        }

    }
    public static Calendar addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal;
    }

}
