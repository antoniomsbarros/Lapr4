package eapli.base.teamManagement.repositories;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Optional;
import java.util.Set;

public interface TeamRepository extends DomainRepository<Uniquecode, Team> {

    Iterable<Team> activeTeams();
    Optional<Team> findByUniquecode(final Uniquecode uniquecode);
    Iterable<ClientUser> collaboratorList(final Uniquecode uniquecode);
    Iterable<Team> collaboratorTeams(final MecanographicNumber mecanographicNumber);
    Iterable<Team> teamsWithOutThisCollaborator(final MecanographicNumber mecanographicNumber);
    Iterable<Team> responsibleTeams(final ClientUser clientUser);
}
