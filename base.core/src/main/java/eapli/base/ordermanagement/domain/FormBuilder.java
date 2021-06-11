package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

import java.util.List;

public class FormBuilder implements DomainFactory<Form> {

    private Description name;

    private Description script;

    private List<Attribute> attribute;

    public FormBuilder() { }

    public FormBuilder withName(Description name) {
        this.name = name;
        return this;
    }

    public FormBuilder withScript(Description script) {
        this.script = script;
        return this;
    }

    public FormBuilder withAttribute(List<Attribute> at) {
        this.attribute = at;
        return this;
    }

    @Override
    public Form build() {
        return new Form(this.name, this.script);
    }
}
