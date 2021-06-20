package eapli.base.app.backoffice.console.presentation.ManualTask;

import eapli.base.app.backoffice.console.presentation.clientuser.collaboratorDTOListPrinter;
import eapli.base.app.backoffice.console.presentation.clientuser.teamDTOListPrinter;
import eapli.base.clientusermanagement.dto.ClientUserDTO;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.Request;
import eapli.base.taskmanagement.application.DoManualTaskPendingController;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.domain.TaskType;
import eapli.base.teamManagement.dto.TeamDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marly
 */
public class DoManualTaskPendingUI extends AbstractUI {
    private final DoManualTaskPendingController controller = new DoManualTaskPendingController();
    private boolean opValida = false;
    private SelectWidget<ManualTask> manualTaskSelectWidget;

    @Override
    protected boolean doShow() {
        Form form;
        Request request;
        do {
            System.out.println("Search by:");
            System.out.println("1.Approval");
            System.out.println("2.Resolution");
            System.out.println("0. Exit");

            final int op = Console.readInteger("Search Option: ");
            switch (op){
                case 0: return true;
                case 1:
                    manualTaskSelectWidget = new SelectWidget<>("Select the Approval Manual Task:",
                            controller.manualTaskPendingList(TaskType.APPROVAL), new ManualTaskPrinter());
                    if (controller.manualTaskPendingList(TaskType.APPROVAL).iterator().hasNext()){
                        manualTaskSelectWidget.show();
                        try {
                            ManualTask manualTask = manualTaskSelectWidget.selectedElement();
                            System.out.println("Manual Task: " + manualTask.identity());

                            request = controller.ViewRequestAnswer(manualTask);
                            List<String> answers = request.Answers();
                            System.out.println("Request Answers: \n" + answers);
                            answers = new ArrayList<>();

                            form = manualTask.Form();

                            for (Attribute attribute: form.attribute()){
                                System.out.println(attribute.toString());
                                String resposta = Console.readLine("Insert the Answer: ");
                                answers.add(resposta);
                            }

                            manualTask.insertAnswers(answers);
                            controller.doManualTaskPending(manualTask);
                        }catch (NullPointerException e){
                            System.out.println("Invalid Option: " + e);
                        }
                    }
                    else {
                        System.out.println("Without Approval Manual Task!");
                    }

                    opValida = true;
                    break;
                case 2:

                    manualTaskSelectWidget = new SelectWidget<>("Select the Resolution Manual Task:",
                            controller.manualTaskPendingList(TaskType.RESOLUTION), new ManualTaskPrinter());
                    if (controller.manualTaskPendingList(TaskType.RESOLUTION).iterator().hasNext()){
                        manualTaskSelectWidget.show();
                        try {
                            ManualTask manualTask = manualTaskSelectWidget.selectedElement();
                            System.out.println("Manual Task: " + manualTask.identity());

                            request = controller.ViewRequestAnswer(manualTask);
                            List<String> answers = request.Answers();
                            System.out.println("Request Answers: \n" + answers);

                            form = manualTask.Form();

                            for (Attribute attribute: form.attribute()){
                                System.out.println(attribute.toString());
                                String resposta = Console.readLine("Insert the Answer: ");
                                answers.add(resposta);
                            }

                            manualTask.insertAnswers(answers);

                            controller.doManualTaskPending(manualTask);
                        }catch (NullPointerException e){
                            System.out.println("Invalid Option: " + e);
                        }
                    }
                    else {
                        System.out.println("Without Resolution Manual Task!");
                    }

                    opValida = true;
                    break;
                default: opValida = false;
            }
        }while (!opValida);

        return false;
    }

    @Override
    public String headline() {
        return "Do Manual Task Pending";
    }
}
