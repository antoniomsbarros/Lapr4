package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.CreateServiceController;
import eapli.base.catalogmanagement.domain.Keyword;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class CreateServiceUI extends AbstractUI {
    CreateServiceController controller;

    public CreateServiceUI() {
        this.controller  = new CreateServiceController();
    }

    @Override
    protected boolean doShow() {
        final Description title = Description.valueOf(Console.readLine("Title: "));
        final Description smalldescription = Description.valueOf(Console.readLine("Small Description: "));
        final Description fulldescription = Description.valueOf(Console.readLine("Full Description: "));
        final Description icon = Description.valueOf(Console.readLine("Icon: "));

        controller.createService(title,smalldescription,fulldescription,icon);

        String answer = "y";
        Keyword keyword;
        while (answer.equals("y")) {
            keyword = new Keyword(Console.readLine("keyword: "));
            controller.addKeyword(keyword);
            answer = Console.readLine("Do you wish to add more keywords? (y/n)");
        }

        controller.addKeywordListToService();
        answer = Console.readLine("Do you want to enable feedback in this service? (y/n)");
        if (answer.equals("y"))
            controller.enableFeedback();
        else
            controller.disableFeedback();

        //System.out.println(controller.getCatalogs());
        //Long id = Console.readLong("Choose an id of a Catalog: ");
        //Optional<Catalog> choosenCatalog = controller.getCatalogByIdentifier(id);
        List<Form> lstForm = new ArrayList<>();
        List<Attribute> lstAttribute = new ArrayList<>();

        System.out.println("Formulario de solicitacao de servico:");
        answer = "y";
        String answer2 = "y";
        while(answer.equals("y")) {

            /*Form Info*/
            final Description nameForm = Description.valueOf( Console.readLine("Form name: "));
            //controller.addForm(nameForm);

            /*Attribute Info*/
            while (answer2.equals("y")) {
                final Long id = Long.valueOf("10");
                System.out.println(id);
                final Description description = Description.valueOf(Console.readLine("Description: "));
                final Description nameAttribute = Description.valueOf(Console.readLine("Attribute name: "));
                final Description label = Description.valueOf(Console.readLine("Label: "));
                final Description regularexpression = Description.valueOf(Console.readLine("Regular expression: "));
                final Description script = Description.valueOf(Console.readLine("Script: "));
                final TypeofData td = TypeofData.valueOf(Console.readLine("Choose a data type (INTEGER, String, Bool, Data, Ficheiro, ListaDeValores): "));
                Attribute at = controller.addAttribute(id, description, nameAttribute, label, regularexpression, script, td);
                lstAttribute.add(at);
                System.out.println(at);
                answer2 = Console.readLine("Do you want to add more Attributes to the Form?(y/n)");
            }
            lstForm.add(controller.saveForm(nameForm,lstAttribute));

            answer = Console.readLine("Do you want to add a manual task Form?(y/n)");
        }
        String temp = Console.readLine("Do you confirm the data (y/n)");
        if(temp.equals("n"))
            return false;

        Service createdService = controller.saveService(/*choosenCatalog*/lstForm);
        System.out.println("Service created.\n" + createdService);
        return true;
    }

    @Override
    public String headline() {
        return "Create Service";
    }
}
