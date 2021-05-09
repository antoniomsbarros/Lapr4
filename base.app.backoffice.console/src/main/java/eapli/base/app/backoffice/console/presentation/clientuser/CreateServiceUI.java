package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.CreateCatalogController;
import eapli.base.catalogmanagement.application.CreateServiceController;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Keyword;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Optional;

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

        System.out.println(controller.getCatalogs());
        Long id = Console.readLong("Choose an id of a Catalog: ");
        Optional<Catalog> choosenCatalog = controller.getCatalogByIdentifier(id);

        final Description nameForm = Description.valueOf( Console.readLine("Form name: "));
        controller.addForm(nameForm);

        final Description description = Description.valueOf( Console.readLine("Description: "));
        final Description nameAttribute = Description.valueOf( Console.readLine("Attribute name: "));
        final Description label = Description.valueOf( Console.readLine("Label: "));
        final Description regularexpression = Description.valueOf( Console.readLine("Regular expression: "));
        final Description script = Description.valueOf( Console.readLine("Script: "));
        controller.addAttribute(description, nameAttribute, label, regularexpression, script);

        TypeofData td = TypeofData.valueOf(Console.readLine("Choose a data type (INTEGER, String, Bool, Data, Ficheiro, ListaDeValores): "));
        controller.addAttributeType(td);

        controller.saveForm();

        String temp = Console.readLine("Do you confirm the data (y/n)");
        if(temp.equals("n"))
            return false;

        Service createdService = controller.saveService(choosenCatalog);

        return true;
    }

    @Override
    public String headline() {
        return "Create Service";
    }
}
