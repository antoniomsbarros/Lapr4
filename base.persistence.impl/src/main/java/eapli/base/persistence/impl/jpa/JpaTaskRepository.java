package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTaskRepository extends JpaAutoTxRepository<Task,Long,Long> implements TaskRepository {
    public JpaTaskRepository(TransactionalContext autoTx) {
        super(autoTx, "taskCode");
    }

    public JpaTaskRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(),
                "taskCode");
    }

    public JpaTaskRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }
}
