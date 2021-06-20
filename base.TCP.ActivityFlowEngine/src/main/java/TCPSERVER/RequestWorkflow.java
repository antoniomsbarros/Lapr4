package TCPSERVER;

import eapli.base.catalogmanagement.application.*;
import eapli.base.catalogmanagement.domain.Responsable;
import eapli.base.catalogmanagement.domain.Sequence;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.ordermanagement.application.ChangeStatusRequest;
import eapli.base.ordermanagement.application.CreateFormController;
import eapli.base.ordermanagement.application.SearchRequestController;
import eapli.base.ordermanagement.application.SearchTickController;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.ordermanagement.domain.State;
import eapli.base.ordermanagement.domain.Ticket;
import eapli.base.taskmanagement.application.*;
import eapli.base.taskmanagement.domain.*;
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
    private CreateFormController createFormController;
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
        createFormController=new CreateFormController();
    }

    public void createWorkflowPedido(String idPedido) throws InterruptedException {
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
        int size=tasks.size()+ manualTasks.size();
        List<Sequence> sequenceList=new LinkedList<>();
        Workflow workflowRequest = null;
        int da=0;
        List<Long> integers=new LinkedList<>();
        ///implementaction of creting and executing
        int numberoftaskitdecisonReprovado=0;
        for (int i = 0; i <size ; i++) {

            if (manualTasks.containsKey(i)){
                changeStatusRequest.changeStatusofRequest(request, State.EMAPROVACAO);
                ManualTask manualTask1=manualTasks.get(i);
                Calendar date=addDays(new Date(), 15);
                Responsable responsable=new Responsable();
                // atribuição do responsable US 4072
                Form form=manualTasks.get(i).Form();
                createFormController=new CreateFormController();
                int adsd=413234;
                for (int j = 0; j < form.attribute().size(); j++) {
                    createFormController.addAttribute(j+ request.identity()+adsd+i+da,form.attribute().get(i).description(),
                            form.attribute().get(i).name(), form.attribute().get(i).label(),form.attribute().get(i).Regularexpression(), form.attribute().get(i).typeofData());
                }
                Form formRequestTask= createFormController.saveForm(form.Formname(), form.Script(),form.formType().name());
                da++;
                createFormController=new CreateFormController();
                Deadline deadline = new Deadline(date);

                ManualTask manualTask=addManualTaskController.addManualTask(deadline, manualTask1.priority(), searchActivity.prepareTask(112345).get(0).Responsible(),new Executor() ,Description.valueOf("Aprovado"), Description.valueOf("comment") ,formRequestTask,new ArrayList<>());

                integers.add(manualTask.identity());


                SearchManualTask searchManualTask=new SearchManualTask();
                Sequence sequence= sequenceController.createSequence(searchManualTask.getmanualtask(manualTask.identity()), (long) i);
                sequenceList.add(sequence);
                if (i==0){
                    workflowRequest=createWorkflow.createWorkflow(sequenceList);
                }else {
                    workflowRequest= sequenceAddToWorkflow.addSequencesToWorkflow(workflowRequest, sequence);
                }
            }else if (tasks.containsKey(i)){

               while(!integers.isEmpty()){
                   ManualTask manualTask1=searchManualTask.getmanualtask(integers.get(0));
                   changeStatusofActivity.changeStatsTask(manualTask1,TaskState.DONE );
                   System.out.println("inside of the ciclo");
                   System.out.println(manualTask1.decison());
                   if (manualTask1.state().equals(TaskState.DONE)){
                       integers.remove(0);
                       if (!manualTask1.decison().equals("Aprovado")){
                           numberoftaskitdecisonReprovado++;
                       }
                   }
                }
                changeStatusRequest.changeStatusofRequest(request, State.EMRESOLUCAO);
                AutomaticTask automaticTask;
                Calendar date=addDays(new Date(), 15);
                automaticTask=addAutomaticTaskController.addAutomaticTask(date, tasks.get(i).priority(), tasks.get(i).script().toString());
                Sequence sequence=sequenceController.createSequence(automaticTask, (long) i);
                sequenceList.add(sequence);
                workflowRequest= sequenceAddToWorkflow.addSequencesToWorkflow(workflowRequest, sequence);

                if (numberoftaskitdecisonReprovado==0){
                    System.out.println("Aprovado");
                   // TcpClient.tcpConnecting("", automaticTask.identity()+" "+"Aprovado "+request.Answers(),"");
                    System.out.println("tcp executor tarefas");
                    //TcpClientMotorActivityFlowEngine.tcpConnecting(1, String.valueOf(automaticTask.identity()));
                }else {
                    System.out.println("rejeitado");
                    changeStatusRequest.changeStatusofRequest(request, State.REJEITADO);
                }
                changeStatusofActivity.changeStatsTask(automaticTask, TaskState.DONE);
                System.out.println(workflowRequest.toString());
            }

        }
        if (numberoftaskitdecisonReprovado==0){
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
