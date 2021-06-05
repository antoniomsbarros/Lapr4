package eapli.base.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.CollaboratorEmail;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
class JpaClientUserRepository
        extends JpaAutoTxRepository<ClientUser, MecanographicNumber, MecanographicNumber>
        implements ClientUserRepository {

    public JpaClientUserRepository(TransactionalContext autoTx) {
        super(autoTx, "mecanographicNumber");
    }

    public JpaClientUserRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "mecanographicNumber");
    }

    @Override
    public Optional<ClientUser> findByUsername(Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.systemUser.username=:name", params);
    }

    @Override
    public Optional<ClientUser> findByMecanographicNumber(MecanographicNumber number) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", number);
        return matchOne("e.mecanographicNumber=:number", params);
    }

    @Override
    public Iterable<ClientUser> findAllActive() {
        return match("e.systemUser.active = true");
    }

    @Override
    public Optional<ClientUser> getClientUserByEmail(CollaboratorEmail email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return matchOne("e.collaboratorEmail=:email", params);
    }

}
