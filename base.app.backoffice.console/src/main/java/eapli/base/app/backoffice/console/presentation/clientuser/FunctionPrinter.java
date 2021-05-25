package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.funcaomanagement.domain.Function;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author marly
 */
public class FunctionPrinter implements Visitor<Function> {
    @Override
    public void visit(Function visitee) {
        System.out.printf("%-50s%-50s%-50s%n", String.valueOf (visitee.identity()), visitee.Name().toString(),
                visitee.Description().toString());
    }
}
