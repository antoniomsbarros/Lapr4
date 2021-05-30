package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Keyword;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.ServiceBuilder;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Form;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;
import java.util.Set;

@UseCaseController
public class ContinueServiceDraftController {

    private final AuthorizationService authz;
    private final ServiceRepository serviceRepository;
    private ServiceBuilder serviceBuilder;

    public ContinueServiceDraftController() {
        this.authz = AuthzRegistry.authorizationService();
        this.serviceRepository = PersistenceContext.repositories().services();
        this.serviceBuilder = new ServiceBuilder();
    }

    public Iterable<Service> getServicesDraft() {
        return serviceRepository.findAll();
    }

    public Service chooseServiceDraftByID(Long draftID) {
        return serviceRepository.findByID(draftID).get();
    }

    public boolean continueServiceDraft(Set<Keyword> lstKeyword, List<Form> lstForm, Catalog catalog, Description title,
                                        Description smalldescription, Description fulldescription, Description icon, String feedback) {

        Description desc = Description.valueOf("NA");

        if (title.equals(desc) || smalldescription.equals(desc) || fulldescription.equals(desc) || icon.equals(desc) || feedback.equals("NA")) {
            serviceBuilder.withTitle(title).withSmallDescription(smalldescription).withFullDescription(fulldescription).withRequireFeedback(feedback)
                    .withIcon(icon).withKeyword(lstKeyword).withForm(lstForm).withCatalog(catalog).withCompletedService(false);
            return false;
        } else {
            serviceBuilder.withTitle(title).withSmallDescription(smalldescription).withFullDescription(fulldescription).withRequireFeedback(feedback)
                    .withIcon(icon).withKeyword(lstKeyword).withForm(lstForm).withCatalog(catalog).withCompletedService(true);
            return true;
        }
    }

    public Service saveContinuedService(Service oldService) {
        serviceRepository.remove(oldService);
        return serviceRepository.save(serviceBuilder.build());
    }
}
