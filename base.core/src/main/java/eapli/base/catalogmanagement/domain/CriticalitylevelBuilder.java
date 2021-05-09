package eapli.base.catalogmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

import java.awt.*;

public class CriticalitylevelBuilder implements DomainFactory<Criticalitylevel> {

    private Description value;

    private Description tag;

    private Description color;

    private Objective objective;

    public CriticalitylevelBuilder withValue(Description value) {
        this.value = value;
        return this;
    }

    public CriticalitylevelBuilder withTag(Description tag) {
        this.tag = tag;
        return this;
    }

    public CriticalitylevelBuilder withColor(Description color) {
        this.color = color;
        return this;
    }

    public CriticalitylevelBuilder withObjective(Objective objective) {
        this.objective = objective;
        return this;
    }

    @Override
    public Criticalitylevel build() {
        return new Criticalitylevel(this.value, this.tag, this.color, this.objective);
    }
}
