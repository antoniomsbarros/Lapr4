package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.*;

@Entity
public class Form implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long identifier;
    @Version
    private Long version;
    @AttributeOverride(name = "value", column = @Column(name = "name"))
    private Description name;
    @AttributeOverride(name = "value", column = @Column(name = "script"))
    private Description script;
    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "id")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Attribute> attribute = new ArrayList<Attribute>();
    @Enumerated(EnumType.STRING)
    private FormType formType;


    public Form() {
    }

    public Form(final Description name, final Description script,final List<Attribute> attribute, FormType formType) {
        Preconditions.noneNull(name);
        if (name.length()>50){
            throw new IllegalArgumentException("the name of the form cant have more then 50 characters");
        }
        this.name = name;
        this.script = script;
        this.attribute = attribute;
        this.formType = formType;
    }

    public void addListAttributes(final Attribute attribute) {
        this.attribute.add(attribute);
    }

    @Override
    public boolean sameAs(Object other) {
        if(!(other instanceof Form)){
            return false;
        }
        Form form=(Form) other;
        if (this==form){
            return true;
        }
        return name.equals(form.name) && script.equals(form.script)/*attribute.equals(form.attribute)*/;
    }

    @Override
    public Long identity() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Form form = (Form) o;
        return identifier.equals(form.identifier) && version.equals(form.version) && name.equals(form.name) && script.equals(form.script)/* attribute.equals(form.attribute)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, version, name);
    }

    @Override
    public String toString() {
        String ret = "identifier=" + identifier + ", name=" + name.toString() + ", script =" + script + ", Attribute:";
        for (Attribute attribute : this.attribute) {
            ret = ret + attribute.toString();
        }
        return ret;
    }
public Description Formname(){
        return  name;
}
public Description Script(){
        return script;
}
public FormType formType(){
        return formType;
}

    public List<Attribute> attribute(){
        return attribute;
    }
}
