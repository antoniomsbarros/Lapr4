package eapli.base.catalogmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Objective implements ValueObject, Comparable<Objective> {
    
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
        return "MAXTIME=" + maxTime.toString() + ", AVERAGETIME=" + averageTime.toString() + ", STEP=" + step.toString();
    }


    @Override
    public int compareTo(Objective o) {
        if(this.hashCode() > o.hashCode()) {
            return -1;
        } else if (this.hashCode() == o.hashCode()) {
            return 0;
        }else
            return 1;
    }
}
