package eapli.base.persistence.impl.inmemory;

import java.util.Optional;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.CollaboratorEmail;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.TypedQuery;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public class InMemoryClientUserRepository
        extends InMemoryDomainRepository<ClientUser, MecanographicNumber>
        implements ClientUserRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<ClientUser> findByUsername(Username name) {
        return matchOne(e -> e.user().username().equals(name));
    }

    @Override
    public Optional<ClientUser> findByMecanographicNumber(MecanographicNumber number) {
        return Optional.of(data().get(number));
    }

    @Override
    public Iterable<ClientUser> findAllActive() {
        return match(e -> e.user().isActive());
    }

    @Override
    public Optional<ClientUser> getClientUserByEmail(CollaboratorEmail email){
        return matchOne(e -> e.email().equals(email));
    }

}
