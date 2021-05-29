package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.Attribute;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.TypeofData;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import org.hibernate.Session;
import org.springframework.data.jpa.provider.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class InMemoryFormRepository extends InMemoryDomainRepository<Form, Long> implements FormRepository {
    @PersistenceContext
    protected EntityManager entityManager;
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Attribute saveAttribute(Long id, Description description, Description label, Description name, Description regularexpression, Description script, TypeofData dataType) {
        Attribute at = new Attribute(id,description,name,label,regularexpression,script,dataType);
        entityManager.persist(at);
        return at;
    }
}
