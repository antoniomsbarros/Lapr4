package eapli.base.app.backoffice.console.presentation.AutomaticTaskExecution;

import eapli.base.AutomaticTaskExecution.AutomaticTaskExecution;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 *
 * @author marly
 */
public class AutomaticTaskExecutionUI extends AbstractUI {
    final private AutomaticTaskExecution automaticTaskExecution = new AutomaticTaskExecution();
    @Override
    public boolean doShow() {
        final String scriptName = Console.readLine("Script Name: ");
        //automaticTaskExecution.execute(scriptName);
        return false;
    }

    @Override
    public String headline() {
        return "Automatic Task Execution";
    }
}
