package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.ContinueServiceDraftController;
import eapli.base.catalogmanagement.domain.Service;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.general.domain.model.Description;

import java.util.*;

public class ContinueServiceDraftUI extends AbstractUI {
    ContinueServiceDraftController controller;

    public ContinueServiceDraftUI() { this.controller = new ContinueServiceDraftController();}


    @Override
    protected boolean doShow() {
        System.out.println("List of incompleted Services");
        Iterable<Service> lstServiceDrafts = controller.getServicesDraft();
        Long serviceID = chooseDraftID(lstServiceDrafts);
        Service serviceDraft = controller.chooseServiceDraftByID(serviceID);

        Description title = Description.valueOf("NA");
        Description smalldescription = Description.valueOf("NA");
        Description fulldescription = Description.valueOf("NA");
        Description icon = Description.valueOf("NA");
        String feedback = "NA";

        if (serviceDraft.title().equals(title)) {
            title = Description.valueOf(Console.readLine("Title(too leave empty write 'NA'): "));
        } else {
            title = serviceDraft.title();
        }

        if(serviceDraft.smalldescription().equals(smalldescription)) {
            smalldescription = Description.valueOf(Console.readLine("Small Description(too leave empty write 'NA'): "));
        } else {
            smalldescription = serviceDraft.smalldescription();
        }

        if(serviceDraft.fulldescription().equals(fulldescription)) {
            fulldescription = Description.valueOf(Console.readLine("Full Description(too leave empty write 'NA'): "));
        } else {
            fulldescription = serviceDraft.fulldescription();
        }

        if(serviceDraft.icon().equals(icon)) {
            icon = Description.valueOf(Console.readLine("Icon(too leave empty write 'NA'): "));
        } else {
            icon = serviceDraft.icon();
        }

        if(serviceDraft.requirefeedback().equals(feedback)) {
            feedback = Console.readLine("Icon(too leave empty write 'NA'): ");
        } else {
            feedback = serviceDraft.requirefeedback();
        }

        boolean isCompleted = controller.continueServiceDraft(serviceDraft.keyword(), serviceDraft.form(),
                                        serviceDraft.servicecatalog(), title, smalldescription, fulldescription,icon, feedback);

        String temp = Console.readLine("Do you confirm the data (y/n)");
        if(temp.equals("n"))
            return false;

        if (isCompleted) {
            System.out.println("Service is now completed");
        } else {
            System.out.println("Service continue as a draft");
        }

        System.out.println(controller.saveContinuedService(serviceDraft));

        return true;
    }

    public Long chooseDraftID(Iterable<Service> lstServiceDrafts) {
        Iterator<Service> iterator = lstServiceDrafts.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            Service s = iterator.next();
            if (!s.isCompleted()) {
                System.out.println("\t" + i + ". " + s);
            }

        }
        Long choosenId = Long.valueOf(Console.readLine("Choose the ID of the Service Draft you want to complete:"));
        return choosenId;
    }

    @Override
    public String headline() {
        return "Complete Service Draft";
    }




}
