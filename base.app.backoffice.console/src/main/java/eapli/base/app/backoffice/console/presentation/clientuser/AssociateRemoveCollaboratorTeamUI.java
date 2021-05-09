package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.clientusermanagement.application.AssociateRemoveCollaboratorTeamController;
import eapli.base.clientusermanagement.dto.ClientUserDTO;
import eapli.base.teamManagement.dto.TeamDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author marly
 */

public class AssociateRemoveCollaboratorTeamUI extends AbstractUI {

    private final AssociateRemoveCollaboratorTeamController associateRemoveCollaboratorTeamController = new AssociateRemoveCollaboratorTeamController();
    private boolean valida = false;
    @Override
    protected boolean doShow() {

        do {
            System.out.println("Choose the option:");
            System.out.println("1.Associate");
            System.out.println("2.Remove");
            System.out.println("0. Exit");

            final int op = Console.readInteger("Option= ");
            switch (op){
                case 0: return false;
                case 1:

                    final SelectWidget<ClientUserDTO> collaboratorDTOSelectWidget = new SelectWidget<>("Collaborators:",
                            associateRemoveCollaboratorTeamController.collaboratorList(), new collaboratorDTOListPrinter());
                    collaboratorDTOSelectWidget.show();
                    final ClientUserDTO collaboratorDTO = collaboratorDTOSelectWidget.selectedElement();

                    final SelectWidget<TeamDTO> teamDTOSelectWidgets = new SelectWidget<>("Teams:",
                            associateRemoveCollaboratorTeamController.teamList(), new teamDTOListWithoutThisCollaboratorPrinter());
                    teamDTOSelectWidgets.show();
                    final TeamDTO teamDTO = teamDTOSelectWidgets.selectedElement();

                    try {
                        associateRemoveCollaboratorTeamController.associateCollaboratorTeamController(collaboratorDTO.mecanographicNumber,
                                teamDTO.uniquecode);
                    } catch (IllegalArgumentException|IllegalAccessException e){
                        System.out.println(e);
                    }
                    valida = true;
                    break;
                case 2:
                    System.out.println("Without link yet");
                    valida = true;
                    break;
                default: valida = false;
            }
        }while (!valida);

        return false;
    }

    @Override
    public String headline() {
        return "Associate or Remove Collaborator-Team";
    }
}
