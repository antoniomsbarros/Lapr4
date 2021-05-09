package eapli.base.persistence.impl.inmemory;


import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.repositories.TeamTypeRepository;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;


public class InMemoryTeamTypeRepository extends InMemoryDomainRepository<TeamType, Uniquecode>
        implements TeamTypeRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<TeamType> findByColor(Description color) {
        return matchOne(e -> e.teamtype().cor().equals(color));
    }


    @Override
    public Iterable<TeamType> findAll() {
       return findAll();
    }
}
