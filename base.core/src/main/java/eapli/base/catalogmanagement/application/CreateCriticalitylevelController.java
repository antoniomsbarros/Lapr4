package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Criticalitylevel;
import eapli.base.catalogmanagement.domain.CriticalitylevelBuilder;
import eapli.base.catalogmanagement.domain.Objective;
import eapli.base.catalogmanagement.domain.Step;
import eapli.base.catalogmanagement.repository.CriticalityLevelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.general.domain.model.Description;

import java.awt.*;
import java.sql.Time;

public class CreateCriticalitylevelController {
    private CriticalitylevelBuilder criticalityBuilder;
    private final CriticalityLevelRepository criticalityRepository = PersistenceContext.repositories().criticalityLevels();

    public Criticalitylevel createCriticalityLevel(Description value, Description tag, Color color, Time maxTime, Time averageTime, Step step) {
        Objective objective = new Objective(maxTime, averageTime, step);
        criticalityBuilder.withValue(value);
        criticalityBuilder.withTag(tag);
        criticalityBuilder.withColor(color);
        criticalityBuilder.withObjective(objective);
        Criticalitylevel criticalitylevel = criticalityBuilder.build();
        return criticalityRepository.save(criticalitylevel);
    }
}
