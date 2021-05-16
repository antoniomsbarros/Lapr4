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
import java.util.Iterator;

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

        ClientUser clientUser = null;
        ArrayList<Team> listTeams = new ArrayList<>();


        System.out.println("Select a collaborator");
        boolean aux = false;
        Iterator<ClientUser> iterator1 = coontroller.allColaborators().iterator();
        while(iterator1.hasNext() && !aux){
            ClientUser temp = iterator1.next();
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
        Iterator<Team> iterator2 = coontroller.allTeams().iterator();
        while(iterator2.hasNext()){
            Team temp = iterator2.next();
            System.out.println(temp);
            String answer = Console.readLine("This Team (y/n)");
            if (answer.equals("y")){
                listTeams.add(temp);
            }
        }
        if (listTeams.isEmpty()){
            System.out.println("Didn´t select any collaborator");
            return false;
        }

        String temp = Console.readLine("Do you confirm the data (y/n)");
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
