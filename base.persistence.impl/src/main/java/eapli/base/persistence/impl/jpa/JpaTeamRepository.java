package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.funcaomanagement.domain.Function;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class
JpaTeamRepository  extends BasepaRepositoryBase<Team,Uniquecode, Uniquecode> implements TeamRepository {


    public JpaTeamRepository() {
        super("uniquecode");
    }

    @Override
    public Iterable<Team> activeTeams() {
        return match("e.active=true");
    }

    @Override
    public Optional<Team> findByUniquecode(final Uniquecode uniquecode) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", uniquecode);
        return matchOne("e.uniquecode=:number", params);
    }

    @Override
    public Iterable<ClientUser> collaboratorList(final Uniquecode uniquecode) {

        final TypedQuery<ClientUser> q = createQuery("SELECT t.collaboratorList FROM Team t WHERE  t.uniquecode = :id",
                ClientUser.class);
        q.setParameter("id", uniquecode);
        return q.getResultList();
    }

    @Override
    public Iterable<Team> collaboratorTeams(final MecanographicNumber mecanographicNumber) {

        final TypedQuery<Team> q = createQuery("SELECT t FROM Team t JOIN t.collaboratorList clist WHERE clist.mecanographicNumber = :id",
                Team.class);
        q.setParameter("id", mecanographicNumber);
        return q.getResultList();
    }

    @Override
    public Iterable<Team> teamsWithOutThisCollaborator(final MecanographicNumber mecanographicNumber) {

        final TypedQuery<Team> q = createQuery("SELECT t FROM Team t JOIN t.collaboratorList clist WHERE NOT(clist.mecanographicNumber = :id)",
                Team.class);
        q.setParameter("id", mecanographicNumber);
        return q.getResultList();
    }

    @Override
    public Iterable<Team> responsibleTeams(final ClientUser clientUser) {

        final TypedQuery<Team> q = createQuery("SELECT t FROM Team t WHERE t.responsable = :clientUser",
                Team.class);
        q.setParameter("clientUser", clientUser);
        return q.getResultList();
    }

}
