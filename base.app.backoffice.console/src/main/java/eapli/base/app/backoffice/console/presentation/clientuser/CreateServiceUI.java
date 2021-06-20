package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.CreateServiceController;
import eapli.base.catalogmanagement.domain.*;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.ordermanagement.application.CreateFormController;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.base.taskmanagement.application.AddManualTaskController;
import eapli.base.taskmanagement.domain.*;
import eapli.base.teamManagement.application.CreateTeamTypeController;
import eapli.base.teamManagement.application.RegisterTeamController;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class CreateServiceUI extends AbstractUI {
    CreateServiceController controller;
    AddManualTaskController manualTaskController;
    RegisterTeamController teamController;
    CreateFormController formController;

    public CreateServiceUI() {
        this.controller  = new CreateServiceController();
        this.manualTaskController = new AddManualTaskController();
        this.teamController = new RegisterTeamController();
        this.formController = new CreateFormController();
    }

    @Override
    protected boolean doShow() {
        final Description title = Description.valueOf(Console.readLine("Title(too leave empty write 'NA'): "));
        final Description smalldescription = Description.valueOf(Console.readLine("Small Description(too leave empty write 'NA'): "));
        final Description fulldescription = Description.valueOf(Console.readLine("Full Description(too leave empty write 'NA'): "));
        final Description icon = Description.valueOf(Console.readLine("Icon(too leave empty write 'NA'): "));

        // Gets all the CATALOGS
        Iterable<Catalog> lstCatalogs = controller.getCatalogs();
        Long catalogID = chooseCatalog(lstCatalogs);

        //Gets a CATALOG by his ID
        Catalog catalog = controller.getCatalogByIdentifier(catalogID).get();

        // Checks if the service information is complete

        // Inserts some of the SERVICE data
        controller.createService(title,smalldescription,fulldescription,icon,catalog);


        String answer = "y";
        Keyword keyword;
        while (answer.equals("y")) {
            keyword = new Keyword(Console.readLine("keyword(too leave empty write 'NA'): "));
            controller.addKeyword(keyword);
            answer = Console.readLine("Do you wish to add more keywords? (y/n)");
        }

        controller.addKeywordListToService();
        String feedback = Console.readLine("Do you want to enable feedback in this service? (y/n)(too leave empty write 'NA')");
        controller.setFeedback(feedback);

        controller.checkIfServiceIsComplete(title,smalldescription,fulldescription,icon,feedback);

        answer = "y";
        String answer2 = "y";
        while(answer.equals("y")) {

            /*Form Info*/
            System.out.println("-----Form Especification-----");
            final Description nameForm = Description.valueOf( Console.readLine("Form name: "));
            //controller.addForm(nameForm);
            final Description script = Description.valueOf(Console.readLine("Script: "));
            final String formType = Console.readLine("Form type (REQUEST, APROVATION, RESOLUTION):");
            /*Attribute Info*/
            while (answer2.equals("y")) {
                final Long id = Long.valueOf(Console.readLine("ID Attribute: "));
                final Description description = Description.valueOf(Console.readLine("Description: "));
                final Description nameAttribute = Description.valueOf(Console.readLine("Attribute name: "));
                final Description label = Description.valueOf(Console.readLine("Label: "));
                final Description regularexpression = Description.valueOf(Console.readLine("Regular expression: "));
                final TypeofData td = TypeofData.valueOf(Console.readLine("Choose a data type (INTEGER, String, Bool, Data, Ficheiro, ListaDeValores): "));

                controller.addAttribute(id, description, nameAttribute, label, regularexpression, td);

                answer2 = Console.readLine("Do you want to add more Attributes to the Form?(y/n)");
            }
            controller.saveForm(nameForm,script, formType);

            answer = Console.readLine("Do you want to add another Form?(y/n)");
        }

        Map<Long,Task> mapTaskAndOrder = createMultipleTasks();

        List<Sequence> lstSequences = controller.saveSequence(mapTaskAndOrder);
        Workflow workflow = controller.saveWorkflow(lstSequences);


        String temp = Console.readLine("Do you confirm the data (y/n)");
        if(temp.equals("n"))
            return false;

        System.out.println(controller.saveService(workflow));
        System.out.println("Service created successfully.\n");
        return true;
    }

    private Map<Long,Task> createMultipleTasks() {
        String answer = "y";
        Task task;
        Long order;
        Map<Long,Task> mapTaskAndOrder = new HashMap<>();
        while (answer.equals("y")) {
            String typeOfActivity = Console.readLine("Choose type of ACTIVITY to create:\n 1. Manual\n 2. Automatic");
            if(typeOfActivity.equals("1")) {
                task = createManualTask();
                order = Long.valueOf(Console.readLine("Choose the TASK position:"));
                mapTaskAndOrder.put(order, task);
            } else if(typeOfActivity.equals("2")){
                task = createAutomaticTask();
                order = Long.valueOf(Console.readLine("Choose the TASK position:"));
                mapTaskAndOrder.put(order, task);
            }
        }
        return mapTaskAndOrder;
    }

    private Task createAutomaticTask() {
        Calendar date = Calendar.getInstance();

        System.out.println("Deadline");
        int year = Console.readInteger(" ==> Ano da entrega da atividade: ");
        int month = Console.readInteger(" ==> Mes da entrega da atividade: ");
        int day = Console.readInteger(" ==> Dia da entrega da atividade: ");

        date.set(year,month-1,day);

        Integer priority = Console.readInteger("Prioridade: ");

        String scriptPath = Console.readLine("Enter the path to the file:");

        return controller.saveAutomaticTask(date, priority, scriptPath);
    }

    private Task createManualTask() {
        Calendar date = Calendar.getInstance();
        Responsable responsable;
        ClientUser collab = null;
        Team team = null;
        Delegaction delegaction;
        Form form;
        int position;

        Map<Integer, Team> teamsMap;

        System.out.println("Deadline");
        int year = Console.readInteger(" ==> Activity delivery year: ");
        int month = Console.readInteger(" ==> Activity delivery month: ");
        int day = Console.readInteger(" ==> Activity delivery day: ");

        date.set(year,month-1,day);

        Deadline deadline = new Deadline(date);

        Integer priority = Console.readInteger("Priority: ");

        System.out.println("Choose one team: ");

        teamsMap = new HashMap<>();
        Iterator <Team> iterator = teamController.allTeams().iterator();
        position=0;
        while (iterator.hasNext()) {
            Team temp = iterator.next();
            System.out.println(position+": "+ temp.toString());
            teamsMap.put(position, temp);
            position++;
        }


        System.out.println("--Which one want to choose?:");
        position = Console.readInteger("");

        if (teamsMap.containsKey(position)){
            team = teamsMap.get(position);
            //System.out.println("Entrei");
        }

        // System.out.println("Encontrei o collab");
        if (team == null && manualTaskController.getTeamResponsible(collab)==null) {
            System.out.println("Didn't select any team");
        }

        collab = team.clientUser();
        System.out.println("**Choosen collaborator:** \n"+collab.toString());
        Long dumbID = Long.valueOf(Console.readLine("Responsability Id: "));


        Long delegactionID = Long.valueOf(Console.readLine("Delegation Id: "));
        Description justification = Description.valueOf(Console.readLine("Justification: "));
        Designation alternative = Designation.valueOf(Console.readLine("Designation: "));

        delegaction = new Delegaction(delegactionID,justification,alternative);

        responsable = new Responsable(dumbID,collab,delegaction,team);

        String comment = Console.readLine("Comment: ");
        Description commentary = Description.valueOf(comment);

        Description decision = null;

        System.out.println("Decision: \n");

        String approval = "Aprovado";
        String resolution = "Resolvendo";


        System.out.println("1 - Approved\n");
        System.out.println("2 - Solving\n");

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

        String answer = "y";
        /*Form Info*/
        System.out.println("-----Form Especification-----");
        Description name = Description.valueOf(Console.readLine("Form name of Activity:"));
        Description script = Description.valueOf(Console.readLine("Script name of Activity:"));
        final String formType = Console.readLine("Activity's Form type (REQUEST, APROVATION, RESOLUTION):");
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

        form = formController.saveForm(name,script,formType);
        System.out.println(form);

        Answer lstAnswer = new Answer();


        return manualTaskController.addManualTask(deadline,priority,responsable,commentary,decision,form,lstAnswer);
    }

    private Long chooseCatalog(Iterable<Catalog> lstCatalogs){
        Iterator<Catalog> it = lstCatalogs.iterator();
        System.out.println("--List of CATALOGS--");
        while(it.hasNext()) {
            System.out.println("Id: " + it.next().identity() + ", Title: " + it.next().Title());
        }
        Long choosenId = Long.valueOf(Console.readLine("Choose the ID of the CATALOG you want to insert the Service on:"));
        return choosenId;
    }

    @Override
    public String headline() {
        return "Create Service";
    }
}
