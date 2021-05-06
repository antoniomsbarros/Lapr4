package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Form implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long identifier;

    private Description name;


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return identifier;
    }
}
