package eapli.base.catalogmanagement.domain;

import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Objective  {
    @Id
    @GeneratedValue
    private Long id;
    @AttributeOverride(name = "value", column = @Column(name = "maxTime"))
    private Description maxTime;
    @AttributeOverride(name = "value", column = @Column(name = "averageTime"))
    private Description averageTime;
    private Step step;


    public Objective() {
    }

    public Objective(final Description maxTime,final Description averageTime,final Step step) {
        Preconditions.noneNull(maxTime, averageTime, step);
        this.maxTime = maxTime;
        this.averageTime = averageTime;
        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objective objective = (Objective) o;
        return maxTime.equals(objective.maxTime) && averageTime.equals(objective.averageTime) && step == objective.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash( maxTime, averageTime, step);
    }

    @Override
    public String toString() {
        return "id=" + id + ", maxTime=" + maxTime.toString() + ", averageTime=" + averageTime.toString() + ", step=" + step.toString();
    }
}
