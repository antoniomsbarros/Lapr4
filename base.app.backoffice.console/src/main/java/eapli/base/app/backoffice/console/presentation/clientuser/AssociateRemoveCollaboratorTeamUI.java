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
                            associateRemoveCollaboratorTeamController.teamList(), new teamDTOListPrinter());
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
                                final SelectWidget<ClientUserDTO> collaboratorDTORemoveSelectWidgets = new SelectWidget<>("Collaborators:",
                                        associateRemoveCollaboratorTeamController.collaboratorList(), new collaboratorDTOListPrinter());
                                collaboratorDTORemoveSelectWidgets.show();
                                final ClientUserDTO collaboratorDTORemove = collaboratorDTORemoveSelectWidgets.selectedElement();

                                final SelectWidget<TeamDTO> teamDTORemoveSelectWidgets = new SelectWidget<>("Teams:",
                                        associateRemoveCollaboratorTeamController.collaboratorTeams(collaboratorDTORemove.mecanographicNumber),
                                        new teamDTOListPrinter());
                                teamDTORemoveSelectWidgets.show();
                                final TeamDTO teamDTORemove = teamDTORemoveSelectWidgets.selectedElement();

                                    associateRemoveCollaboratorTeamController.removeCollaboratorTeamController(collaboratorDTORemove.mecanographicNumber,
                                            teamDTORemove.uniquecode);

                                opValidaRemove = true;
                                break;
                            case 2:
                                final SelectWidget<TeamDTO> teamDTORemoveSelectWidgets2 = new SelectWidget<>("Teams:",
                                        associateRemoveCollaboratorTeamController.teamList(), new teamDTOListPrinter());
                                teamDTORemoveSelectWidgets2.show();
                                final TeamDTO teamDTORemove2 = teamDTORemoveSelectWidgets2.selectedElement();

                                final SelectWidget<ClientUserDTO> collaboratorDTORemoveSelectWidgets2 = new SelectWidget<>("Collaborators:",
                                        associateRemoveCollaboratorTeamController.teamCollaborators(teamDTORemove2.uniquecode),
                                        new collaboratorDTOListPrinter());
                                collaboratorDTORemoveSelectWidgets2.show();
                                final ClientUserDTO collaboratorDTORemove2 = collaboratorDTORemoveSelectWidgets2.selectedElement();


                                associateRemoveCollaboratorTeamController.removeCollaboratorTeamController(collaboratorDTORemove2.mecanographicNumber,
                                        teamDTORemove2.uniquecode);

                                opValidaRemove = true;
                                break;
                            default: opValidaRemove = false;
                        }
                    }while (!opValidaRemove);

                    opValida = true;
                    break;
                default: opValida = false;
            }
        }while (!opValida);

        return false;
    }

    @Override
    public String headline() {
        return "Associate or Remove Collaborator-Team";
    }
}
