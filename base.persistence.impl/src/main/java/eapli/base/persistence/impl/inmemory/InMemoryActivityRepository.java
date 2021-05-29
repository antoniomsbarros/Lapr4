package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogmanagement.domain.Activity;
import eapli.base.catalogmanagement.repository.ActivityRepository;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryActivityRepository extends InMemoryDomainRepository<Activity,Long> implements ActivityRepository {

    static {
        InMemoryInitializer.init();
    }
    @Override
    public Iterable<Activity> getAtivitiebyCollaborator(Integer RESPONSAVEL_NUMBER) {
        return match(e -> e.responsable().responsable().identity().equals(new MecanographicNumber(String.valueOf(RESPONSAVEL_NUMBER))));
    }
}
