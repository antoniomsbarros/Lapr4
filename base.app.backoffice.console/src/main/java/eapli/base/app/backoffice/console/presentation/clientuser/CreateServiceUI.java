package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.CreateServiceController;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Keyword;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.ordermanagement.domain.Form;
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

        List<Form> lstForm = new ArrayList<>();
        List<Attribute> lstAttribute = new ArrayList<>();

        answer = "y";
        //String answer2 = "y";
        while(answer.equals("y")) {

            /*Form Info*/
            System.out.println("-----Form Especification-----");
            final Description nameForm = Description.valueOf( Console.readLine("Form name: "));
            //controller.addForm(nameForm);
            final Description script = Description.valueOf(Console.readLine("Script: "));
            /*Attribute Info*/
            /*while (answer2.equals("y")) {
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
            }*/
            lstForm.add(controller.saveForm(nameForm,script));

            answer = Console.readLine("Do you want to add a manual task Form?(y/n)");
        }
        String temp = Console.readLine("Do you confirm the data (y/n)");
        if(temp.equals("n"))
            return false;

        Service createdService = controller.saveService(lstForm);
        System.out.println("Service created.\n" + createdService);
        return true;
    }

    public Long chooseCatalog(Iterable<Catalog> lstCatalogs){
        int i = 1;
        Iterator<Catalog> it = lstCatalogs.iterator();
        System.out.println("--List of CATALOGS--");
        while(it.hasNext()) {
            System.out.println(i + ". Id: " + it.next().identity() + ", Title: " + it.next().Title());
            i++;
        }
        Long choosenId = Long.valueOf(Console.readLine("Choose the ID of the CATALOG you want to insert the Service on:"));
        return choosenId;
    }

    @Override
    public String headline() {
        return "Create Service";
    }
}
