package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
//import sun.security.krb5.internal.crypto.Des;

import java.beans.DesignMode;

public class SearchCatalogController {
    private final AuthorizationService authz;
    private final CatalogRepository catalogRepository;

    public SearchCatalogController() {
        this.authz= AuthzRegistry.authorizationService();
        this.catalogRepository = PersistenceContext.repositories().catalogs();
    }

    public Catalog searchCatalogByTittle(Description title){
        return catalogRepository.getCatalogByTitle(title).get();
    }

    public Catalog searchCatalogByShortDescription(Description shortdescription){
        return catalogRepository.getCatalogByShortDescription(shortdescription).get();
    }

    public Catalog searchCatalogByLongDescription(Description longdescription){
        return catalogRepository.getCatalogByLongDescription(longdescription).get();
    }

}
