package eapli.base.clientusermanagement.repositories;

import java.util.Optional;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.CollaboratorEmail;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public interface ClientUserRepository
        extends DomainRepository<MecanographicNumber, ClientUser> {

    /**
     * returns the client user (utente) whose username is given
     *
     * @param name
     *            the username to search for
     * @return
     */
    Optional<ClientUser> findByUsername(Username name);

    /**
     * returns the client user (utente) with the given mecanographic number
     *
     * @param number
     * @return
     */
    default Optional<ClientUser> findByMecanographicNumber(MecanographicNumber number) {
        return ofIdentity(number);
    }

    public Iterable<ClientUser> findAllActive();

    @Query(value = "SELECT Client FROM ClientUser WHERE email = :email",nativeQuery = true)
    Optional<ClientUser> getClientUserByEmail(CollaboratorEmail email);

}
