package eapli.base.catalogmanagement.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Objective  {
    @Id
    @GeneratedValue
    private Long id;
    private Time maxTime;
    private Time averageTime;
    private Step step;


    public Objective() {
    }

    public Objective(final Time maxTime,final Time averageTime,final Step step) {
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
        return id.equals(objective.id) && maxTime.equals(objective.maxTime) && averageTime.equals(objective.averageTime) && step == objective.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maxTime, averageTime, step);
    }

    @Override
    public String toString() {
        return "id=" + id + ", maxTime=" + maxTime.toString() + ", averageTime=" + averageTime.toString() + ", step=" + step.toString();
    }
}
