package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaServiceRepository extends BasepaRepositoryBase<Service,Long,Long> implements ServiceRepository {

    public JpaServiceRepository() {
        super("uniquecode");
    }

    @Override
    public Optional<Service> findById(Long lngID) {
        final Map<String, Object> params = new HashMap<>();
        params.put("serviceID", lngID);
        return matchOne("e.uniquecode=:serviceID", params);
    }

    @Override
    public Iterable<Service> findByCatalog(Catalog catalog) {
        final TypedQuery<Service> query = entityManager().createQuery(
                "SELECT s FROM Service s JOIN s.catalog lst " +
                        "WHERE lst =: catalog", Service.class);
        query.setParameter("catalog", catalog);
        return query.getResultList();
    }

    @Override
    public Optional<Workflow> findbyidServiceworkflow(Long id_service) {
        final Map<String, Object> params=new HashMap<>();
        params.put("serviceID", id_service);
        Optional<Service> optionalService= matchOne("e.id=: serviceID", params);
        System.out.println(optionalService.get().toString());
        return Optional.ofNullable(optionalService.get().workflow());
    }
}

