package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Form implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long identifier;
    @Version
    private Long version;
    @AttributeOverride(name = "value", column = @Column(name = "name"))
    private Description name;
    @OneToMany
    private Set<Attribute> attribute;

    public Form() {
    }

    public Form(final Description name,final Set<Attribute> attribute) {
        Preconditions.noneNull(name);
        if (name.length()>50){
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
        return Objects.hash(identifier, version, name);
    }

    @Override
    public String toString() {

        return "identifier=" + identifier + ", name=" + name.toString() + ", Attribute:" + attribute;
    }
}
