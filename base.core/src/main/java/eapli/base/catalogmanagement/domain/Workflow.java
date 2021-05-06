package eapli.base.catalogmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Workflow implements AggregateRoot<Long> {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(optional = false)
    private Service service;

    public Workflow() {
    }

    public Workflow(final Service service) {
        Preconditions.noneNull(service);
        this.service = service;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Workflow)){
            return false;
        }
        Workflow workflow= (Workflow) other;
        if (this== workflow){
            return true;
        }
        return identity().equals(workflow.identity());
    }

    @Override
    public Long identity() {
        return id;
    }


}
