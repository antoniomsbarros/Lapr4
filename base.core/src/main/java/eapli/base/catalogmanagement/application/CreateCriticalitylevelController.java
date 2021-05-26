package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Criticalitylevel;
import eapli.base.catalogmanagement.domain.CriticalitylevelBuilder;
import eapli.base.catalogmanagement.domain.Objective;
import eapli.base.catalogmanagement.domain.Step;
import eapli.base.catalogmanagement.repository.CriticalityLevelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.awt.*;

@UseCaseController
public class CreateCriticalitylevelController {
    private final AuthorizationService authz;
    private final CriticalityLevelRepository criticalityRepository;
    private final CriticalitylevelBuilder criticalityBuilder;

    public CreateCriticalitylevelController () {
        this.authz = AuthzRegistry.authorizationService();
        this.criticalityRepository = PersistenceContext.repositories().criticalityLevels();
        criticalityBuilder = new CriticalitylevelBuilder();
    }

    public Criticalitylevel createCriticalityLevel(Description value, Description tag, Color color, Description maxTime, Description averageTime, Step step) {
        Objective objective = new Objective(maxTime, averageTime, step);
        criticalityBuilder.withValue(value).withTag(tag).withColor(color).withObjective(objective);
        Criticalitylevel c = criticalityBuilder.build();
        return criticalityRepository.save(c);
    }
}
