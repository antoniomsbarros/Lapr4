package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryFormRepository extends InMemoryDomainRepository<Form, Long> implements FormRepository {
    static {
        InMemoryInitializer.init();
    }
}
