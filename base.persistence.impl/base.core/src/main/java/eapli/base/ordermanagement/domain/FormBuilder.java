package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FormBuilder implements DomainFactory<Form> {

    private Description name;

    private Set<Attribute> attribute;

    public FormBuilder() {
        this.attribute = new HashSet<>();
    }

    public FormBuilder withName(Description name) {
        this.name = name;
        return this;
    }

    public FormBuilder withAttribute(Set<Attribute> at) {
        this.attribute = at;
        return this;
    }

    @Override
    public Form build() {
        return new Form(name, attribute);
    }


}
