package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

public class AttributeBuilder{

    private Description description;

    private Description name;

    private Description label;

    private Description responce;

    private TypeofData typeofData;

    public AttributeBuilder withDescription(Description description) {
        this.description = description;
        return this;
    }

    public AttributeBuilder withName(Description name) {
        this.name = name;
        return this;
    }

    public AttributeBuilder withLabel(Description label) {
        this.label = label;
        return this;
    }

    public AttributeBuilder withResponce(Description responce) {
        this.responce = responce;
        return this;
    }

    public AttributeBuilder withTypeofData(TypeofData typeofData) {
        this.typeofData = typeofData;
        return this;
    }

    public Attribute build() {
        return new Attribute(this.description, this.name, this.label, this.responce, this.typeofData);
    }
}
