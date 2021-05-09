package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.teamManagement.dto.TeamDTO;
import eapli.framework.visitor.Visitor;

public class teamDTOListWithoutThisCollaboratorPrinter implements Visitor<TeamDTO> {
    @Override
    public void visit(TeamDTO visitee) {
        System.out.printf("%-50s%-50s%-50s%n", visitee.uniquecode, visitee.designationTeam,
                visitee.teamAcronym);
    }
}
