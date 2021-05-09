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
    private boolean opValida = false;
    private boolean opValidaRemove = false;
    @Override
    protected boolean doShow() {
 /*
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
                    opValida = true;
                    break;
                case 2:
                    do {
                        System.out.println("Search by:");
                        System.out.println("1.Collaborator");
                        System.out.println("2.Team");
                        System.out.println("0. Exit");

                        final int opRemove = Console.readInteger("Search Option= ");
                        switch (opRemove){
                            case 0: return false;
                            case 1:

                                opValidaRemove = true;
                                break;
                            case 2:

                                //opValidaRemove = true;
                                break;
                            default: opValidaRemove = false;
                        }
                    }while (!opValidaRemove);

                    opValida = true;
                    break;
                default: opValida = false;
            }
        }while (!opValida);
*/
        return false;
    }

    @Override
    public String headline() {
        return "Associate or Remove Collaborator-Team";
    }
}
