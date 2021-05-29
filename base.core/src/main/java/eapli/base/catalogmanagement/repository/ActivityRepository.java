package eapli.base.catalogmanagement.repository;

import eapli.base.catalogmanagement.domain.Activity;
import eapli.framework.domain.repositories.DomainRepository;


public interface ActivityRepository extends DomainRepository<Long, Activity> {

    Iterable<Activity> getAtivitiebyCollaborator( Integer RESPONSAVEL_NUMBER);
}
