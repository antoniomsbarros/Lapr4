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
    private List<Sequence> sequences;

    public Workflow() {
    }

    public Workflow( List<Sequence> sequences) {
        Preconditions.noneNull(sequences);
        this.sequences = sequences;
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
    public List<Sequence> Sequences() {
        return sequences;
    }
    public void AlterListofSequences(List<Sequence> sequences){
        this.sequences=sequences;
    }
    @Override
    public Long identity() {
        return id;
    }

    @Override
    public String toString() {
        return "Workflow{" +
                "id=" + id +
                '}';
    }


}
