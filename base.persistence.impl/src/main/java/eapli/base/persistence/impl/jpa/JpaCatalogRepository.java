package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

class JpaCatalogRepository extends JpaAutoTxRepository<Catalog,Long,Long> implements CatalogRepository {

    public JpaCatalogRepository(final TransactionalContext autoTx){
        super(autoTx,"identifier");
    }

    public JpaCatalogRepository(String name){
        super(name, Application.settings().getExtendedPersistenceProperties(),"identifier");
    }

    public JpaCatalogRepository(){
        super("identifier", Application.settings().getExtendedPersistenceProperties(),"identifier");
    }

    @Override
    public Iterable<Catalog> getAllCatalogs() {
        return match("e.systemUser.active=true");
    }


}
