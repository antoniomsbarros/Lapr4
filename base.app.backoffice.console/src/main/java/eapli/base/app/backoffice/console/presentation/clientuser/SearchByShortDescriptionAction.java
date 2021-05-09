package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.framework.actions.Action;

public class SearchByShortDescriptionAction implements Action {
    @Override
    public boolean execute() {
        return new SearchByShortDescriptionUI().show();
    }
}
