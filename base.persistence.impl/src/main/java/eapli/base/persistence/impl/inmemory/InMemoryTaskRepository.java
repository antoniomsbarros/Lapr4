package eapli.base.persistence.impl.inmemory;

import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTaskRepository extends InMemoryDomainRepository<Task,Long> implements TaskRepository {

    static {
        InMemoryInitializer.init();
    }
}
