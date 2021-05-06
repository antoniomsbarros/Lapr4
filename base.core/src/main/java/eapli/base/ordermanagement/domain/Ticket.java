package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Ticket implements AggregateRoot<Long> {
    @Id
    @GeneratedValue
    private Long identifier;

    private Integer priorityTicket;

    @OneToOne(optional = false)
    private Request request;

    public Ticket() {
    }

    public Ticket(final Integer priorityTicket, Request request) {
        Preconditions.noneNull(request, priorityTicket);
        if (priorityTicket<0){
            throw new IllegalArgumentException("the priority of the ticket cant be negative");
        }
        this.priorityTicket = priorityTicket;
        this.request=request;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Ticket)){
            return false;
        }
        Ticket ticket= (Ticket) other;
        if (this==ticket){
            return true;
        }
        return  identity().equals(ticket.identity()) && priorityTicket.equals(ticket.priorityTicket)
                && request.equals(ticket.request);
    }

    @Override
    public Long identity() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return identifier.equals(ticket.identifier) && priorityTicket.equals(ticket.priorityTicket)
                && request.equals(ticket.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, priorityTicket, request);
    }
    public Integer PriorityTicket(){
        return  priorityTicket;
    }
    public  Request request(){
        return  request;
    }

    @Override
    public String toString() {
        return "identifier=" + identifier.toString() + ", priorityTicket=" + priorityTicket.toString() +
                ", request=" + request.toString();
    }
}
