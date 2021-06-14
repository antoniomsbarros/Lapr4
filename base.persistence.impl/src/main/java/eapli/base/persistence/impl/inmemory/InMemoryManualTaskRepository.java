package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.ManualTask;
import eapli.base.taskmanagement.domain.TaskType;
import eapli.base.taskmanagement.repositories.AutomaticTaskRepository;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryManualTaskRepository  extends InMemoryDomainRepository<ManualTask, Long>
        implements ManualTaskRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<ManualTask> findAllActive() {
        return null;
    }

    @Override
    public Optional<ManualTask> findByID(Long id) {
        return Optional.of(data().get(id));
    }

    @Override
    public Optional<ManualTask> findByType(TaskType type){ return Optional.of(data().get(type));
    }

    @Override
    public Iterable<ManualTask> manualTaskToClaim(final Team team){
        throw new UnsupportedOperationException("NOT IMPLEMENTED YET");
    }

    @Override
    public Iterable<ManualTask> findManualTaskbyCollaborator(Integer Collaborator) {
        //return match(e -> e.responsable().responsable().identity().equals(new MecanographicNumber(String.valueOf(RESPONSAVEL_NUMBER))));
        return match(e->e.Responsible().identity().equals(String.valueOf(Collaborator)));
    }
}

