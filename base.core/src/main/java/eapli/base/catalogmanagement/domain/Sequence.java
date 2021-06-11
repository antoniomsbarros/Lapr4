package eapli.base.catalogmanagement.domain;

import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.List;


@Entity
public class Sequence implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long id;

    private Long position;
    @OneToOne
    private Task activity;

    public Sequence() {
    }

    public Sequence(Long position, Task activity) {
        this.position = position;
        this.activity = activity;
    }

    public Sequence(final Long posicao) {
        Preconditions.noneNull(posicao);
        if (posicao<0){
            throw new IllegalArgumentException("The position cant be negative");
        }
        this.position = posicao;
    }


    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Sequence)){
            return true;
        }
        Sequence sequence =(Sequence) other;
        if (this== sequence){
            return true;
        }
        return identity().equals(sequence.identity()) && position.equals(sequence.position);
    }

    @Override
    public Long identity() {
        return this.id;
    }

    public Task tasks(){
        return activity;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "id=" + id +
                ", position=" + position +
                ", activity=" + activity +
                '}';
    }
}
