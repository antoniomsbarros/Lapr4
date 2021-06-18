package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.CreateServiceController;
import eapli.base.catalogmanagement.domain.Delegaction;
import eapli.base.catalogmanagement.domain.Responsable;
import eapli.base.clientusermanagement.application.ClientUserService;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.ordermanagement.application.CreateFormController;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.base.taskmanagement.application.AddManualTaskController;
import eapli.base.taskmanagement.domain.Answer;
import eapli.base.taskmanagement.domain.Deadline;
import eapli.base.taskmanagement.domain.TaskState;
import eapli.base.taskmanagement.domain.TaskType;
import eapli.base.teamManagement.application.RegisterTeamController;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;


import java.util.*;

public class CreateManualTaskUI extends AbstractUI {

    private AddManualTaskController controller;
    private RegisterTeamController teamController;
    private CreateFormController formController;



    public CreateManualTaskUI() {
        this.controller = new AddManualTaskController();
        this.teamController = new RegisterTeamController();
        this.formController = new CreateFormController();
    }

    @Override
    protected boolean doShow() {

        Calendar date = Calendar.getInstance();
        TaskState taskState =TaskState.PENDING;
        TaskType taskType = TaskType.UNKNOWN;
        Responsable responsable = null;
        ClientUser collab = null;
        Team team = null;
        Delegaction delegaction = null;
        Form form = new Form();
        int position;


        boolean aux = false;
        Map<Integer, Team> teamsMap;

        System.out.println("Deadline");

        System.out.println("Anos disponiveis: [2010-2021]");

        int year = Console.readInteger(" ==> Ano da entrega da atividade: ");
        int month = Console.readInteger(" ==> Mes da entrega da atividade: ");
        int day = Console.readInteger(" ==> Dia da entrega da atividade: ");

        date.set(year,month-1,day);

        Deadline deadline = new Deadline(date);

        Integer priority = Console.readInteger("Prioridade: ");

        System.out.println("Escolha uma equipa: ");

        teamsMap = new HashMap<>();
        Iterator <Team> iterator = teamController.allTeams().iterator();
        position=0;
        while (iterator.hasNext()) {
            Team temp = iterator.next();
            System.out.println(position+": "+ temp.toString());
            teamsMap.put(position, temp);
            position++;
        }
        position=-1;


        System.out.println("--Qual pretende escolher?:");
        position = Console.readInteger("");

        //position = 0;
        if (teamsMap.containsKey(position)){
            team = teamsMap.get(position);
        //System.out.println("Entrei");
        }

       // System.out.println("Encontrei o collab");
        if (team == null && controller.getTeamResponsible(collab)==null) {
            System.out.println("Nao selecionou nenhuma equipa");
        }
       // System.out.println("Saí");


    /**
        * Selecionar o responsavel-colaborador da equipa a que pertence
    */
       /* Iterable<ClientUser> collabIT = teamController.allColaborators();

        while(iterator.hasNext()){
            while(collabIT.iterator().hasNext() && iterator.next().exist(collabIT.iterator().next())) {
                collab = collabIT.iterator().next();
            }
        }*/

        collab = team.clientUser();
        System.out.println("**Collaborador escolhido:** \n"+collab.toString());
        Long dumbID = Long.valueOf(Console.readLine("Id de responsabilidade: "));

        /*  while(collabIT.hasNext()){
            collab = collabIT.next();
        }

        System.out.println(collab.toString());
         System.out.println(team.toString());
        */
        Long delegactionID = Long.valueOf(Console.readLine("Id de delegacao: "));
        Description justification = Description.valueOf(Console.readLine("Justificacao: "));
        Designation alternative = Designation.valueOf(Console.readLine("Designacao: "));

        delegaction = new Delegaction(delegactionID,justification,alternative);
        //System.out.println(justification.toString());
        //System.out.println(alternative.toString());

        responsable = new Responsable(dumbID,collab,delegaction,team);

        String comment = Console.readLine("Comentário: ");
        Description commentary = Description.valueOf(comment);

        Description decision = null;

        System.out.println("Decisão: \n");

        position = 0;

        String approval = "Aprovado";
        String resolution = "Resolvendo";


        System.out.println("1 - Aprovado\n");
        System.out.println("2 - Resolvendo\n");

        position = Console.readInteger("");

        switch(position){
            case 1 :
               decision = Description.valueOf(approval);
                break;
            case 2:
                decision =  Description.valueOf(resolution);
                break;

                default  :
                decision = Description.valueOf("Unknown");

        }

        if (!decision.isEmpty() && decision.toString().equalsIgnoreCase("Aprovado")){
            taskType = TaskType.APPROVAL;
        } else{
            taskType = TaskType.RESOLUTION;
        }



        String answer = "y";

        /*Form Info*/
        System.out.println("-----Form Especification-----");
        Description name = Description.valueOf(Console.readLine("Nome da Form da Atividade:"));
        Description script = Description.valueOf(Console.readLine("Nome do Script da Form da Atividade:"));
        /*Attribute Info*/
        while (answer.equals("y")) {
            final Long id = Long.valueOf(Console.readLine("ID Attribute: "));
            final Description description = Description.valueOf(Console.readLine("Description: "));
            final Description nameAttribute = Description.valueOf(Console.readLine("Attribute name: "));
            final Description label = Description.valueOf(Console.readLine("Label: "));
            final Description regularexpression = Description.valueOf(Console.readLine("Regular expression: "));
            final TypeofData td = TypeofData.valueOf(Console.readLine("Choose a data type (INTEGER, String, Bool, Data, Ficheiro, ListaDeValores): "));

            formController.addAttribute(id, description, nameAttribute, label, regularexpression, td);

            answer = Console.readLine("Do you want to add more Attributes to the Form?(y/n)");
            }

        form = formController.saveForm(name,script);
        System.out.println(form);

        Attribute atb = new Attribute(Long.valueOf(1),Description.valueOf("DescAttrb1"),Description.valueOf("Attrb1"),Description.valueOf("LBL1"),Description.valueOf("regularExp"), TypeofData.Data);

        List<Answer> lstAnswer = new ArrayList<>();


        controller.addManualTask(deadline,priority,responsable,commentary,decision,form,lstAnswer);

        return true;
    }
    @Override
    public String headline() {
       return "Create Manual Task";
    }
}
