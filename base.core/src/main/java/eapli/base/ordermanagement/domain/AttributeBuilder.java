package eapli.base.ordermanagement.domain;

import eapli.framework.general.domain.model.Description;

public class AttributeBuilder{

    private Description description;

    private Description name;

    private Description label;

    private Description regularexpression;

    private Description script;

    private TypeofData typeofData;

    public AttributeBuilder() {}

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

    public AttributeBuilder withRegularExpression(Description regularexpression) {
        this.regularexpression = regularexpression;
        return this;
    }

    public AttributeBuilder withScript(Description script) {
        this.script = script;
        return this;
    }

    public AttributeBuilder withTypeofData(TypeofData typeofData) {
        this.typeofData = typeofData;
        return this;
    }

    public Attribute build() {
        return new Attribute(this.description, this.name, this.label, this.regularexpression, this.script, this.typeofData);
    }
}
