package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.framework.actions.Action;

public class AssociateRemoveCollaboratorTeamAction implements Action {
    @Override
    public boolean execute() {
        return new AssociateRemoveCollaboratorTeamUI().show();
    }
}
