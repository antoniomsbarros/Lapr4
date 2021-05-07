package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

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
        return false;
    }

    @Override
    public Long identity() {
        return identifier;
    }
}
