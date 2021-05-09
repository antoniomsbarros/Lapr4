package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.CreateCatalogController;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
//import sun.security.krb5.internal.crypto.Des;

import javax.swing.*;
import java.util.ArrayList;

public class CreateCatalogUI extends AbstractUI {
    CreateCatalogController coontroller;

    public CreateCatalogUI() {
        this.coontroller  = new CreateCatalogController();
    }

    @Override
    protected boolean doShow() {
        final Description title = Description.valueOf( Console.readLine("Title: "));
        final Description shortdescription = Description.valueOf( Console.readLine("Short Description: "));
        final Description longdescription = Description.valueOf( Console.readLine("Long Description: "));
        final Description icon = Description.valueOf( Console.readLine("Icone: "));
        final Description listTeams = Description.valueOf( Console.readLine("team: "));
        final Description clientUser = Description.valueOf( Console.readLine("cliente: "));

        /*
        ClientUser clientUser=null;
        ArrayList<Team> listTeams = new ArrayList<>();

/*
        System.out.println("Select a collaborator");
        boolean aux = false;
        while(coontroller.allColaborators().iterator().hasNext() && !aux){
            ClientUser temp = coontroller.allColaborators().iterator().next();
            System.out.println(temp);
            String answer = Console.readLine("This Collaborator (y/n)");
            if(answer.equals("y")){
                clientUser=temp;
                aux=true;
            }
        }
        if (clientUser==null){
            System.out.println("Didn´t select any collaborator");
            return false;
        }

        System.out.println("Select the teams");
        while(coontroller.allTeams().iterator().hasNext()){
            Team temp = coontroller.allTeams().iterator().next();
            System.out.println(temp);
            String answer = Console.readLine("This Collaborator (y/n)");
            if (answer.equals("y")){
                listTeams.add(temp);
            }
        }
*/
        String temp = Console.readLine("Do yoou confirm the data (y/n)");
        if(temp.equals("n")){
            return false;
        }

        coontroller.addCatalog(title, shortdescription, longdescription, icon, listTeams, clientUser);


        return true;
    }

    @Override
    public String headline() {
        return "Create Catalog";
    }

}
