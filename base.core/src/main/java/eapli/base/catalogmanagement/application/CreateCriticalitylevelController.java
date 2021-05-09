package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Criticalitylevel;
import eapli.base.catalogmanagement.domain.CriticalitylevelBuilder;
import eapli.base.catalogmanagement.domain.Objective;
import eapli.base.catalogmanagement.domain.Step;
import eapli.base.catalogmanagement.repository.CriticalityLevelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.general.domain.model.Description;

public class CreateCriticalitylevelController {
    private CriticalitylevelBuilder criticalityBuilder;
    private final CriticalityLevelRepository criticalityRepository = PersistenceContext.repositories().criticalityLevels();

    public Criticalitylevel createCriticalityLevel(Description value, Description tag, Description color, Description maxTime, Description averageTime, Step step) {
        Objective objective = new Objective(maxTime, averageTime, step);
        criticalityBuilder.withValue(value);
        criticalityBuilder.withTag(tag);
        criticalityBuilder.withColor(color);
        criticalityBuilder.withObjective(objective);
        Criticalitylevel criticalitylevel = criticalityBuilder.build();
        return criticalityRepository.save(criticalitylevel);
    }
}
