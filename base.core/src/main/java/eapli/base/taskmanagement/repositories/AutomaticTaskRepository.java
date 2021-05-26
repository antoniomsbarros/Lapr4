package eapli.base.taskmanagement.repositories;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

/**
 *
 * @author marly
 */
public interface AutomaticTaskRepository extends DomainRepository<Long, AutomaticTask> {

    Iterable<AutomaticTask> findAllActive();
    Optional<AutomaticTask> findByID(Long id);
}
