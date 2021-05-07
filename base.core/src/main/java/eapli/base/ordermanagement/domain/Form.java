package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.Objects;

@Entity
public class Form implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long identifier;
    @Version
    private Long version;
    private Description name;
    private Attribute attribute;

    public Form() {
    }

    public Form(Description name, Attribute attribute) {
        Preconditions.noneNull(name,attribute);
        if (name.length()<50){
            throw new IllegalArgumentException("the name of the form cant have more then 50 characters");
        }
        this.name = name;
        this.attribute = attribute;
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
        return identity().equals(form.identity()) && name.equals(form.name) && attribute.equals(form.attribute);
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
        return identifier.equals(form.identifier) && version.equals(form.version) && name.equals(form.name) && attribute.equals(form.attribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, version, name, attribute);
    }

    @Override
    public String toString() {
        return "identifier=" + identifier + ", name=" + name + ", attribute=" + attribute.toString();
    }
}
