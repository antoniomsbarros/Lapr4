package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class InMemoryTeamRepository extends InMemoryDomainRepository<Team, Uniquecode> implements TeamRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Team> activeTeams() {
        return match(Team::isActive);
    }

    @Override
    public Optional<Team> findByUniquecode(final Uniquecode uniquecode) {
        return Optional.of(data().get(uniquecode));
    }

    @Override
    public Iterable<ClientUser> collaboratorList(Uniquecode uniquecode) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED YET");
    }

    @Override
    public Iterable<Team> collaboratorTeams(MecanographicNumber mecanographicNumber) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED YET");
    }

    @Override
    public Iterable<Team> teamsWithOutThisCollaborator(MecanographicNumber mecanographicNumber) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED YET");
    }

    @Override
    public Iterable<Team> responsibleTeams(final ClientUser clientUser) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED YET");
    }
}
