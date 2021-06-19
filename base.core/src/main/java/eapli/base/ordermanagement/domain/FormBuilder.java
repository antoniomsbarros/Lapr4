package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

import java.util.ArrayList;
import java.util.List;

public class FormBuilder implements DomainFactory<Form> {

    private Description name;

    private Description script;

    private List<Attribute> attribute = new ArrayList<Attribute>();

    private FormType formType;

    public FormBuilder() { }

    public FormBuilder withName(Description name) {
        this.name = name;
        return this;
    }

    public FormBuilder withScript(Description script) {
        this.script = script;
        return this;
    }

    public FormBuilder withAttribute(Attribute at) {
        this.attribute.add(at);
        return this;
    }

    public FormBuilder withFormType(String formType) {
        this.formType = FormType.valueOf(formType);
        return this;
    }

    @Override
    public Form build() {
        return new Form(this.name, this.script, this.attribute, this.formType);
    }
}
