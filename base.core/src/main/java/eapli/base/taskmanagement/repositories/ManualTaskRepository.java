package eapli.base.taskmanagement.repositories;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.domain.TaskType;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ManualTaskRepository extends DomainRepository<Long, ManualTask> {
    Iterable<ManualTask> findAllActive();
    Optional<ManualTask> findByID(Long id);
    Optional<ManualTask> findByType(TaskType type);
    Iterable<ManualTask> manualTaskToClaim(final Team team);
}
