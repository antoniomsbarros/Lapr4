package eapli.base.app.backoffice.console.presentation.AutomaticTaskExecution;

import eapli.base.AutomaticTaskExecution.AutomaticTaskExecution;
import eapli.framework.actions.Action;

/**
 *
 * @author marly
 */
public class AutomaticTaskExecutionAction implements Action {
    @Override
    public boolean execute() {
        return new AutomaticTaskExecutionUI().doShow();
    }
}
