package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SearchService {
    private final AuthorizationService authz;
    private ServiceRepository serviceRepository;

    public SearchService() {
        this.authz = AuthzRegistry.authorizationService();
        this.serviceRepository = PersistenceContext.repositories().services();
    }

    public Service findServices(Long id_service){
        return serviceRepository.findByID(id_service).get();
    }
}
