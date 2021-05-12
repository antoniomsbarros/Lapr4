package eapli.base.app.backoffice.console.presentation.clientuser;


import eapli.base.teamManagement.application.CreateTeamTypeController;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class CreateTeamTypeAction extends AbstractUI {
    CreateTeamTypeController controller;

    public CreateTeamTypeAction() {
        this.controller  = new CreateTeamTypeController();
    }



    @Override
    protected boolean doShow() {
       final Description color = Description.valueOf( Console.readLine("Color: "));
       final Description description = Description.valueOf( Console.readLine("Description: "));

       String singleInternCode =Console.readLine("Insert a Unique Code for the TeamType: ");
       Uniquecode code = Uniquecode.valueOf(singleInternCode);

       if (controller.singleInternCodeAndColorAlreadyExists(code.Code(),color.toString())){
           return false;
       }

        String temp = Console.readLine("Do you confirm the data (y/n)");
        if(temp.equals("n")){
            return false;
        }

        controller.registerTeamType(code,color,description);
       return true;
    }

    @Override
    public String headline() {
        return "Create Team Type";
    }
}
