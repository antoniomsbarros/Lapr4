package eapli.base.app.backoffice.console.presentation.ManualTask;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author marly
 */
public class ManualTaskPrinter implements Visitor<ManualTask> {
    @Override
    public void visit(ManualTask visitee) {
        System.out.printf("%s - Responsible: %s\n", visitee.toString(), visitee.Responsible().responsable().toString());
    }
}
