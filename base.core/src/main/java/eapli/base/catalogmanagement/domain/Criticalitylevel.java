package eapli.base.catalogmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.*;
import java.util.Objects;

@Entity
public class Criticalitylevel implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long id;

    private Description tag;

    private Color color;

    private Objective objective;

    public Criticalitylevel() {
    }

    public Criticalitylevel(final Description tag,final Color color,final Objective objective) {
        Preconditions.noneNull(tag,color,objective);
        this.tag = tag;
        this.color = color;
        this.objective = objective;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Criticalitylevel)){
            return false;
        }
        Criticalitylevel criticalitylevel=(Criticalitylevel) other;
        if (this==criticalitylevel){
            return true;
        }
        return identity().equals(criticalitylevel.identity()) && tag.equals(((Criticalitylevel) other).tag)
                && objective.equals(criticalitylevel.objective);

    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criticalitylevel that = (Criticalitylevel) o;
        return id.equals(that.id) && tag.equals(that.tag) && color.equals(that.color) && objective.equals(that.objective);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tag, color, objective);
    }

    @Override
    public String toString() {
        return "id=" + id.toString() + ", tag=" + tag.toString() + ", color=" + color.toString() + ", objective=" + objective.toString() +
                '}';
    }
}