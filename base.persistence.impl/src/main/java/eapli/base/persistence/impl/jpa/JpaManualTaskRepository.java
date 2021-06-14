package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Activity;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.domain.TaskType;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
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

    @Override
    public Iterable<ManualTask> manualTaskToClaim(final Team team) {

        final TypedQuery<ManualTask> q = createQuery("SELECT m FROM ManualTask m " +
                        " WHERE (m.collaborator.team =:team) AND (m.collaborator.responsable = null)",
                ManualTask.class);
        q.setParameter("team", team);
        return q.getResultList();
    }

    @Override
    public Iterable<ManualTask> findManualTaskbyCollaborator(Integer Collaborator) {
        /*TypedQuery<Activity> query = createQuery("Select a from eapli.base.catalogmanagement.domain.Activity a INNER JOIN " +
                "eapli.base.catalogmanagement.domain.Responsable r ON r.id=a.responsable where r.responsable.mecanographicNumber.number=: number", Activity.class);

        query.setParameter("number",String.valueOf(RESPONSAVEL_NUMBER));
        return query.getResultList();*/
        TypedQuery<ManualTask> query1=createQuery("Select a from eapli.base.taskmanagement.domain.ManualTask a INNER JOIN "+
                "eapli.base.catalogmanagement.domain.Responsable r ON r.id=a.collaborator where r.responsable.mecanographicNumber.number=: number", ManualTask.class);
        query1.setParameter("number",String.valueOf(Collaborator));
        return query1.getResultList();
    }
}


