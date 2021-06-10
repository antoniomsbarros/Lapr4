package eapli.base.app.backoffice.console.presentation.ManualTask;

import eapli.framework.actions.Action;

/**
 *
 * @author marly
 */
public class SearchManualTaskToClaimAction implements Action {
    @Override
    public boolean execute() {
        return new SearchManualTaskToClaimUI().doShow();
    }
}
