package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author marly
 */

public class CollaboratorPrinter implements Visitor<ClientUser> {

    @Override
    public void visit(ClientUser visitee) {
        System.out.printf("%-50s%-50s%-50s%n", visitee.mecanographicNumber().toString(), visitee.fullname().toString(),
                visitee.email().email());
    }
}
