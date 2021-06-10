package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaServiceRepository extends JpaAutoTxRepository<Service,Long,Long> implements ServiceRepository {

    public JpaServiceRepository(final TransactionalContext autoTx){
            super(autoTx,"uniquecode");
        }
        
    public JpaServiceRepository(String name){
        super(name, Application.settings().getExtendedPersistenceProperties(),"uniquecode");
    }

    public JpaServiceRepository(){
        super("uniquecode", Application.settings().getExtendedPersistenceProperties(),"uniquecode");
    }

    @Override
    public Optional<Service> findById(Long lngID) {
        final Map<String, Object> params = new HashMap<>();
        params.put("serviceID", lngID);
        return matchOne("e.id=:serviceID", params);
    }

    @Override
    public Iterable<Service> findByCatalog(Catalog catalog) {
        final Map<String,Object> params = new HashMap<>();
        params.put("catalog", catalog);
        return match("e.catalog=:catalog",params);
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

