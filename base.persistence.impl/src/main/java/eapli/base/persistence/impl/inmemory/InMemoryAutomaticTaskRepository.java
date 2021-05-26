package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.AutomaticTaskRepository;
import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.repositories.TeamTypeRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

/**
 *
 * @author marly
 */
public class InMemoryAutomaticTaskRepository extends InMemoryDomainRepository<AutomaticTask, Long>
        implements AutomaticTaskRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<AutomaticTask> findAllActive() {
        return match(Task::isActive);
    }

    @Override
    public Optional<AutomaticTask> findByID(Long id) {
        return Optional.of(data().get(id));
    }
}
