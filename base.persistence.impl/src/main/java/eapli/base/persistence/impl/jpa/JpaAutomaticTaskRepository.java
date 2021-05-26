package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.repositories.AutomaticTaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author marly
 */
public class JpaAutomaticTaskRepository extends JpaAutoTxRepository<AutomaticTask, Long, Description>
        implements AutomaticTaskRepository {

    public JpaAutomaticTaskRepository(TransactionalContext autoTx) {
        super(autoTx, "taskCode");
    }

    public JpaAutomaticTaskRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(),
                "taskCode");
    }

    public JpaAutomaticTaskRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    @Override
    public Iterable<AutomaticTask> findAllActive() {
        return match("e.active = true");
    }

    @Override
    public Optional<AutomaticTask> findByID(Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", id);
        return matchOne("e.taskCode=:number", params);
    }

    @Override
    public Optional<AutomaticTask> ofIdentity(Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", id);
        return matchOne("e.taskCode=:number", params);
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }
}
