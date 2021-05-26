package eapli.base.catalogmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

import java.awt.*;

public class CriticalitylevelBuilder implements DomainFactory<Criticalitylevel> {

    private Description value;

    private Description tag;

    private Color color;

    private Objective objective;

    public CriticalitylevelBuilder(){}

    public CriticalitylevelBuilder (final Description value, final Description tag,
                                    final Color color, Objective objective){
        this.value = value;
        this.tag = tag;
        this.color = color;
        this.objective = objective;
    }

    public CriticalitylevelBuilder withValue(Description value) {
        this.value = value;
        return this;
    }

    public CriticalitylevelBuilder withTag(Description tag) {
        this.tag = tag;
        return this;
    }

    public CriticalitylevelBuilder withColor(Color color) {
        this.color = color;
        return this;
    }

    public CriticalitylevelBuilder withObjective(Objective objective) {
        this.objective = objective;
        return this;
    }

    @Override
    public Criticalitylevel build() {
        return new Criticalitylevel(value, tag, color, objective);
    }
}
