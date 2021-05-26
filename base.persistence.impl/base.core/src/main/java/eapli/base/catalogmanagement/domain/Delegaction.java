package eapli.base.catalogmanagement.domain;


import eapli.framework.domain.model.DomainEntity;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Delegaction implements DomainEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    private Description justification;

    private Designation alternative;

    public Delegaction() {
    }

    public Delegaction(Description justification, Designation alternative) {
        Preconditions.noneNull(justification, alternative);
        this.justification = justification;
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "Delegaction{" +
                "id=" + id +
                ", justification=" + justification.toString() +
                ", alternative=" + alternative.toString() +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Delegaction)){
            return  false;
        }
        final  Delegaction draft=(Delegaction) other;

        return identity().equals(draft.identity()) && justification.equals(draft.justification)
                && alternative.equals(draft.alternative);
    }

    @Override
    public Long identity() {
        return id;
    }
}
