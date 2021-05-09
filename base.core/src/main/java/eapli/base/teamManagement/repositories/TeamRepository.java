package eapli.base.teamManagement.repositories;

import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.repositories.DomainRepository;

public interface TeamRepository extends DomainRepository<Uniquecode, Team> {
}
