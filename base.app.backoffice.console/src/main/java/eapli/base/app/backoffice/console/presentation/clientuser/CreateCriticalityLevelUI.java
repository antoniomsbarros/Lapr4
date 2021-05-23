package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.CreateCriticalitylevelController;
import eapli.base.catalogmanagement.domain.Step;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.awt.*;

public class CreateCriticalityLevelUI extends AbstractUI {
    CreateCriticalitylevelController controller;

    public CreateCriticalityLevelUI() {
        this.controller  = new CreateCriticalitylevelController();
    }

    @Override
    protected boolean doShow() {
        final Description value = Description.valueOf(Console.readLine("Value: "));
        final Description tag = Description.valueOf(Console.readLine("Tag: "));
        final int red = Integer.parseInt(Console.readLine("Color red component[0-255]: "));
        final int green = Integer.parseInt(Console.readLine("Color green component[0-255]: "));
        final int blue = Integer.parseInt(Console.readLine("Color blue component[0-255]: "));
        final Color color = new Color(red, green, blue);
        final Description maxTime = Description.valueOf(Console.readLine("Maximum time: "));
        final Description averageTime = Description.valueOf(Console.readLine("Average time: "));
        final String step = Console.readLine("Step (resolution(1)/aprovation(2)): ");
        Step s;
        if (step.equals("1")) {
            s = Step.RESOLUTION;
        } else {
            s = Step.APROVATION;
        }

        String temp = Console.readLine("Do you confirm the data (y/n)");
        if(temp.equals("n")){
            return false;
        }

        System.out.println("## ## ##" +controller.createCriticalityLevel(value, tag, color, maxTime, averageTime, s));

        return true;
    }

    @Override
    public String headline() {
        return "Create Criticality level";
    }
}
