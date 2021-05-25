package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaTransactionalRepository;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

class JpaCatalogRepository extends BasepaRepositoryBase<Catalog,Long,Long> implements CatalogRepository {

    public JpaCatalogRepository() {
        super("identifier");
    }

    @Override
    public Optional<Catalog> getCatalogByTitle(Description title) {
        final Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        return matchOne("e.title=:title", params);
    }

    @Override
    public Optional<Catalog> getCatalogByShortDescription(Description shortdescription){
        final Map<String, Object> params = new HashMap<>();
        params.put("shortdescription", shortdescription);
        return matchOne("e.shortdescription=:shortdescription", params);
    }

    @Override
    public Optional<Catalog> getCatalogByLongDescription(Description longdescription){
        final Map<String, Object> params = new HashMap<>();
        params.put("longdescription", longdescription);
        return matchOne("e.longdescription=:longdescription", params);
    }

    @Override
    public Iterable<Catalog> findByTeams(Team team) {

            final TypedQuery<Catalog> query = entityManager().createQuery(
                    "SELECT c FROM eapli.base.catalogmanagement.domain.Catalog as c WHERE eapli.base.catalogmanagement.domain.Catalog.team = team", Catalog.class);
            query.setParameter("eapli.base.catalogmanagement.domain.Catalog.team", team);
            return query.getResultList();
        }
    }

}
