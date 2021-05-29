package eapli.base.catalogmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.awt.*;
import java.util.Objects;

@Entity
public class Criticalitylevel implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @AttributeOverride(name = "value", column = @Column(name = "value"))
    private Description value;
    @AttributeOverride(name = "value", column = @Column(name = "tag"))
    private Description tag;
    private Color color;
    private Objective objective;

    public Criticalitylevel() {
    }

    public Criticalitylevel(final Description value, final Description tag,final Color color,final Objective objective) {
        Preconditions.noneNull(value,tag,color,objective);
        this.value = value;
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
        return identity().equals(criticalitylevel.identity()) && value.equals(((Criticalitylevel) other).value) &&
                tag.equals(((Criticalitylevel) other).tag)
                && objective.equals(criticalitylevel.objective);

    }

    @Override
    public Long identity() {
        return id;
    }

    public Description value() { return value;}

    public Description tag() { return tag;}

    public Color color() { return color;}

    public Objective objective() { return objective; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criticalitylevel that = (Criticalitylevel) o;
        return id.equals(that.id) && value.equals(that.value) && tag.equals(that.tag) && color.equals(that.color) && objective.equals(that.objective);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, id, tag, color, objective);
    }

    @Override
    public String toString() {
        return "{ID=" + id.toString() + ", VALUE=" + value.toString() + ", TAG=" + tag.toString() + ", COLOR=" + color.toString() + ", OBJECTIVE=" + objective.toString() ;
    }
    public String print(){
        return "VALUE=" + value.toString() + ", TAG=" + tag.toString() + ", COLOR=" + color.toString() + ", OBJECTIVE=" + objective.toString() ;
    }
}
