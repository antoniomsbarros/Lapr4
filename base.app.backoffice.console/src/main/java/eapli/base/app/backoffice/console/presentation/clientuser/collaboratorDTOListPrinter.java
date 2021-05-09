package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.clientusermanagement.dto.ClientUserDTO;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author marly
 */

public class collaboratorDTOListPrinter implements Visitor<ClientUserDTO> {
    @Override
    public void visit(ClientUserDTO visitee) {
        System.out.printf("%-50s%-50s%-50s%n", visitee.mecanographicNumber, visitee.fullName,
                visitee.email);
    }
}
