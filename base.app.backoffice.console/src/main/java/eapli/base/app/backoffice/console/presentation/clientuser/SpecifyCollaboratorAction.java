package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.framework.actions.Action;

/**
 *
 * @author marly
 */

public class SpecifyCollaboratorAction implements Action {
    @Override
    public boolean execute() {
        return new SpecifyCollaboratorUI().show();
    }
}
