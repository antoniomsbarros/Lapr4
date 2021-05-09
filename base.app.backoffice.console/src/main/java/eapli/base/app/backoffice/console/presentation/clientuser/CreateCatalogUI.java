package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.CreateCatalogController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
//import sun.security.krb5.internal.crypto.Des;

public class CreateCatalogUI extends AbstractUI {
    CreateCatalogController coontroller;


    @Override
    protected boolean doShow() {
        final Description title = Description.valueOf( Console.readLine("Title: "));
        final Description shortdescription = Description.valueOf( Console.readLine("Short Description: "));
        final Description longdescription = Description.valueOf( Console.readLine("Long Description: "));
        //final Description icone = Description.valueOf( Console.readLine("Icone: "));



        return true;
    }

    @Override
    public String headline() {
        return "Create Catalog";
    }

    public void addCatalog(Description title, Description shortDescription, Description longDescription){

    }
}
