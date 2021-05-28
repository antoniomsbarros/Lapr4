package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientusermanagement.domain.SignupRequest;
import eapli.base.infrastructure.bootstrapers.TestDataConstants;
import eapli.base.myclientuser.application.SignupController;
import eapli.base.taskmanagement.application.AddAutomaticTaskController;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 *
 * @author marly
 */
public class AutomaticTaskBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            AutomaticTaskBootstrapper.class);

    private final AddAutomaticTaskController addAutomaticTaskController = new AddAutomaticTaskController();

    @Override
    public boolean execute() {
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date1.set(2021,11,30);
        date2.set(2021,8,13);
        addAutomaticTask(date1, 10, "C:/Users/Acer/Desktop/semestre/lprog/a.exe");
        addAutomaticTask(date2,5,"C:/Users/Acer/Desktop/semestre/lprog/b.exe");
        return true;
    }

    private void addAutomaticTask(final Calendar deadline, final Integer priority,
                                           final String scriptPath) {

       addAutomaticTaskController.addAutomaticTask(deadline, priority, scriptPath);
    }
}
