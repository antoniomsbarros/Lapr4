package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.domain.Delegaction;
import eapli.base.catalogmanagement.domain.Responsable;
import eapli.base.clientusermanagement.application.ClientUserService;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.taskmanagement.application.AddManualTaskController;
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


    public CreateManualTaskUI() {
        this.controller = new AddManualTaskController();
        this.teamController = new RegisterTeamController();
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
        int position;


        boolean aux = false;
        Map<Integer, Team> teamsMap;

        System.out.println("Deadline");

        System.out.println("Anos disponiveis: [2010-2021]");

        int year = Console.readInteger(" ==> Ano da entrega da atividade: ");
        int month = Console.readInteger(" ==> Mes da entrega da atividade: ");
        int day = Console.readInteger(" ==> Dia da entrega da atividade: ");

        if (( year > 2020) && (month>6 && month<13) && (day>0 && day<32)){
            date.set(year,month,day);
        } else {
            System.out.println("Campos da data são inválidos");
        }

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

        /*  while(collabIT.hasNext()){
            collab = collabIT.next();
        }

        System.out.println(collab.toString());
         System.out.println(team.toString());
        */

        Description justification = Description.valueOf(Console.readLine("Justificacao: "));
        Designation alternative = Designation.valueOf(Console.readLine("Designacao: "));

        delegaction = new Delegaction(justification,alternative);
        //System.out.println(justification.toString());
        //System.out.println(alternative.toString());

        responsable = new Responsable(collab,delegaction,team);

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

        controller.addManualTask(date,priority,responsable,commentary,decision);

        return true;
    }

    @Override
    public String headline() {
       return "Create Manual Task";
    }
}
