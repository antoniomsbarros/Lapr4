package eapli.base.catalogmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Order implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long id;

    private Long position;

    public Order() {
    }

    public Order(final Long posicao) {
        Preconditions.noneNull(posicao);
        if (posicao<0){
            throw new IllegalArgumentException("The position cant be negative");
        }
        this.position = posicao;
    }


    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Order)){
            return true;
        }
        Order order=(Order) other;
        if (this== order){
            return true;
        }
        return identity().equals(order.identity()) && position.equals(order.position);
    }

    @Override
    public Long identity() {
        return this.id;
    }


}
