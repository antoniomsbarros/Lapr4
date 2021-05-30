package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Activity;
import eapli.base.catalogmanagement.repository.ActivityRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity {
    private final AuthorizationService authz;
    private final ActivityRepository activityRepository;

    public SearchActivity() {
        this.authz = AuthzRegistry.authorizationService();;
        this.activityRepository = PersistenceContext.repositories().activity();
    }
    public List<Activity> prepareactivity(Integer collaboratorNumber){
        Iterable<Activity> iterable= activityRepository.getAtivitiebyCollaborator(collaboratorNumber);
        List<Activity> list=new ArrayList<>();
        iterable.forEach(activity -> list.add(activity));
        return list;
    }
}