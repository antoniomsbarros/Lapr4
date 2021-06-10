package eapli.base.app.backoffice.console.presentation.ManualTask;

import eapli.base.app.backoffice.console.presentation.clientuser.CollaboratorPrinter;
import eapli.base.app.backoffice.console.presentation.clientuser.FunctionPrinter;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.taskmanagement.application.ManualTaskToClaimController;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author marly
 */
public class SearchManualTaskToClaimUI extends AbstractUI {

    private final ManualTaskToClaimController manualTaskToClaimController = new ManualTaskToClaimController();

    @Override
    protected boolean doShow() {

        final SelectWidget<ManualTask> manualTaskSelectWidget = new SelectWidget<>("Select the Manual Task:",
                manualTaskToClaimController.manualTaskToClaimList(), new ManualTaskPrinter());
        if (manualTaskToClaimController.manualTaskToClaimList().iterator().hasNext()){
            manualTaskSelectWidget.show();
            try {
                ManualTask manualTask = manualTaskSelectWidget.selectedElement();
                System.out.println("Manual Task: " + manualTask.identity());
                manualTaskToClaimController.claim(manualTask);
            }catch (NullPointerException e){
                System.out.println("Invalid Option: " + e);
            }
        }
        else {
            System.out.println("Without ManualTask!");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Search Manual Task To Claim";
    }
}
