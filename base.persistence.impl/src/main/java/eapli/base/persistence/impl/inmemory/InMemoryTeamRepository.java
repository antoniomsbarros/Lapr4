package eapli.base.persistence.impl.inmemory;

import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTeamRepository extends InMemoryDomainRepository<Team, Uniquecode> implements TeamRepository {
    static {
        InMemoryInitializer.init();
    }

}
