package TCPSERVER;

import eapli.base.catalogmanagement.application.*;
import eapli.base.catalogmanagement.domain.Responsable;
import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.ordermanagement.application.ChangeStatusRequest;
import eapli.base.ordermanagement.application.SearchRequestController;
import eapli.base.ordermanagement.application.SearchTickController;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.domain.State;
import eapli.base.ordermanagement.domain.Ticket;
import eapli.base.taskmanagement.application.*;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.Deadline;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.domain.TaskState;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import java.util.*;

public class RequestWorkflow {

    private final SearchWorkflowService searchWorkflowService;
    private final SearchManualTask searchManualTask;
    private final SearchAutomaticTask searchAutomaticTask;
    private final CreateWorkflow createWorkflow;
    private final AddAutomaticTaskController addAutomaticTaskController;
    private final AddManualTaskController addManualTaskController;
    private final SearchRequestController searchRequestController;
    private final SearchTickController searchTickController;
    private final ChangeStatusRequest changeStatusRequest;
    private final ChangeStatusofActivity changeStatusofActivity;
    private final SearchService searchService;
    private final SearchActivity searchActivity;
    private final SequenceAddToWorkflow sequenceAddToWorkflow;

    public RequestWorkflow() {

        this.searchWorkflowService = new SearchWorkflowService();
        searchManualTask=new SearchManualTask();
        searchAutomaticTask=new SearchAutomaticTask();
        createWorkflow=new CreateWorkflow();
        addAutomaticTaskController=new AddAutomaticTaskController();
        addManualTaskController=new AddManualTaskController();
        searchRequestController=new SearchRequestController();
        searchTickController=new SearchTickController();
        changeStatusRequest=new ChangeStatusRequest();
        changeStatusofActivity=new ChangeStatusofActivity();
        searchService=new SearchService();
        searchActivity=new SearchActivity();
        sequenceAddToWorkflow=new SequenceAddToWorkflow();
    }

    public void createWorkflowPedido(String idPedido){
        Preconditions.noneNull(idPedido);
        Request request=searchRequestController.getrequestbyid(Long.valueOf(idPedido));
        Ticket ticket=searchTickController.searchTickbyRequestid(request.identity());
        Workflow workflow= searchWorkflowService.getWorkflowByService(ticket.TicketService().identity());
        changeStatusRequest.changeStatusofRequest(request, State.EMRESOLUCAO);
        Map<Integer, AutomaticTask> tasks=new HashMap<>();
        Map<Integer, ManualTask> manualTasks=new HashMap<>();


        for (int i = 0; i < workflow.Sequences().size(); i++) {
            try {
                AutomaticTask automaticTask= searchAutomaticTask.automaticTaskbyid(workflow.Sequences().get(i).tasks().identity());
                tasks.put(i,automaticTask);
            }catch (NoSuchElementException e){
                ManualTask manualTask= searchManualTask.getmanualtask(workflow.Sequences().get(i).tasks().identity());
                manualTasks.put(i, manualTask);
            }
        }
        System.out.println("Manual task size: "+manualTasks.size());
        System.out.println("Automatic task size: "+tasks.size());

        CreateSequenceController sequenceController=new CreateSequenceController();
        List<Sequence> sequences=new LinkedList<>();
        sequences.add(sequenceController.createSequence(manualTasks.get(0),1L));
        int size=tasks.size()+ manualTasks.size();
        List<Sequence> sequenceList=new LinkedList<>();
        List<Form> formList=searchService.findServices(ticket.TicketService().identity()).form();
        Workflow workflowRequest=null;

        int error=0;
        ///implementaction of creting and executing
        for (int i = 0; i <size ; i++) {
            Long id=0L;
            if (manualTasks.containsKey(i)){
                changeStatusRequest.changeStatusofRequest(request, State.EMAPROVACAO);
                ManualTask manualTask1=manualTasks.get(i);
                Calendar date=addDays(new Date(), 15);
                Responsable responsable=new Responsable();
                // atribuição do responsable US 4072





                Form form= formList.get(i);

                Deadline deadline = new Deadline(date);
                ManualTask manualTask=addManualTaskController.addManualTask(deadline, manualTask1.priority(), searchActivity.prepareTask(112345).get(0).Responsible(),Description.valueOf("ola") , Description.valueOf("ola"), form,request.Answers());
                id=manualTask.identity();

                System.out.println(id);
                SearchManualTask searchManualTask=new SearchManualTask();
                //System.out.println(manualTask.toString());
                Sequence sequence= sequenceController.createSequence(searchManualTask.getmanualtask(manualTask.identity()), (long) i);
                sequenceList.add(sequence);
                if (i==0){
                    workflowRequest=createWorkflow.createWorkflow(sequenceList);
                }else {
                    workflowRequest= sequenceAddToWorkflow.addSequencesToWorkflow(workflow, sequence);
                }
                System.out.println("sequencelist "+sequenceList.size());
            }else if (tasks.containsKey(i)){
                boolean value=true;
                ManualTask manualTask = null;
               while(value && id.intValue()!=0){
                     manualTask=searchManualTask.getmanualtask(id);
                    if (manualTask.state().equals(TaskState.DONE)){
                        value=false;
                    }
                }
                changeStatusRequest.changeStatusofRequest(request, State.EMRESOLUCAO);
                AutomaticTask automaticTask;
                Calendar date=addDays(new Date(), 15);
                automaticTask=addAutomaticTaskController.addAutomaticTask(date, tasks.get(i).priority(), tasks.get(i).script().toString());
                Sequence sequence=sequenceController.createSequence(automaticTask, (long) i);
                sequenceList.add(sequence);
                /////US 4071
                if (manualTask.decison().equals("Aprovado")){
                    System.out.println("Aprovado");
                   // TcpClient.tcpConnecting("", automaticTask.identity()+" "+"Aprovado "+request.Answers(),"");
                }else {
                    System.out.println("rejeitado");
                    //TcpClient.tcpConnecting("", automaticTask.identity()+" "+"Rejeitado "+request.Answers(),"");
                    error++;
                }
                changeStatusofActivity.changeStatsTask(automaticTask, TaskState.DONE);

            }
        }
      //  Workflow workflowRequest=createWorkflow.createWorkflow(sequenceList);
        if (error==0){
            changeStatusRequest.changeStatusofRequest(request, State.CONCLUIDO);
        }else {
            changeStatusRequest.changeStatusofRequest(request, State.REJEITADO);
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
