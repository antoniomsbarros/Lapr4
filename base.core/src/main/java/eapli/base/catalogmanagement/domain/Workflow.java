package eapli.base.catalogmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.List;

@Entity
public class Workflow implements AggregateRoot<Long> {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Order> orders;

    public Workflow() {
    }

    public Workflow( List<Order> orders) {
        Preconditions.noneNull(orders);
        this.orders = orders;
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
