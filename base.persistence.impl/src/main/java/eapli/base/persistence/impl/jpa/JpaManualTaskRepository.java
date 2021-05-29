package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.domain.TaskType;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaManualTaskRepository extends JpaAutoTxRepository<ManualTask, Long,Long>
        implements ManualTaskRepository {

    public JpaManualTaskRepository(TransactionalContext autoTx) {
        super(autoTx, "taskCode");
    }

    public JpaManualTaskRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(),
                "taskCode");
    }

    public JpaManualTaskRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    @Override
    public Iterable<ManualTask> findAllActive() {
        return null;
    }

    @Override
    public Optional<ManualTask> findByID(Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", id);
        return matchOne("e.taskCode=:number", params);
    }

    @Override
    public Optional<ManualTask> findByType(TaskType type) {
        final Map<String, Object> params = new HashMap<>();
        params.put("type", type);
        return matchOne("e.taskType=:type", params);
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }
}


