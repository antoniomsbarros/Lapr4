package eapli.base.teamManagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

public class TeamTypeBuilder implements DomainFactory<TeamType> {

    private Uniquecode singleInternCode;
    private Description color;
    private Description description;

    public TeamTypeBuilder withUniqueCode (String singleInternCode){
        this.singleInternCode = Uniquecode.valueOf(singleInternCode);
        return this;
    }

    public TeamTypeBuilder withDescription (Description description){
        this.description = description;
        return this;
    }

    public TeamTypeBuilder withColor(Description color){
        this.color = color;
        return this;
    }

    @Override
    public TeamType build() {
        return new TeamType(singleInternCode,color,description);
    }
}
