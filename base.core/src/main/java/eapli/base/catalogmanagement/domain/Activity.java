package eapli.base.catalogmanagement.domain;

import eapli.base.ordermanagement.domain.State;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
public class Activity implements AggregateRoot<Long> {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;
    private Calendar dateconclusionL;
    private TypeofActivitie typeofActivitie;
    @AttributeOverride(name = "value", column = @Column(name = "typeofexection"))
    private Description typeofexection;
    private Long priority;
    private State state;
    @AttributeOverride(name = "value", column = @Column(name = "decision"))
    private Description decision;
    @AttributeOverride(name = "value", column = @Column(name = "coment"))
    private Description coment;
    @AttributeOverride(name = "value", column = @Column(name = "complementaryinformation"))
    private Description complementaryinformation;



    public Activity() {
    }

    public Activity(Calendar dateconclusionL, TypeofActivitie typeofActivitie,
                    Description typeofexection, Long priority, State state, Description decision, Description coment,
                    Description complementaryinformation) {
        Preconditions.noneNull(dateconclusionL,typeofActivitie,typeofexection,  priority, state);
        this.dateconclusionL = dateconclusionL;
        this.typeofActivitie = typeofActivitie;
        this.typeofexection = typeofexection;
        this.priority = priority;
        this.state = state;
        this.decision = decision;
        this.coment = coment;
        this.complementaryinformation = complementaryinformation;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id.equals(activity.id) && version.equals(activity.version) && dateconclusionL.equals(activity.dateconclusionL) && typeofActivitie == activity.typeofActivitie && typeofexection.equals(activity.typeofexection) && priority.equals(activity.priority) && state == activity.state && decision.equals(activity.decision) && coment.equals(activity.coment) && complementaryinformation.equals(activity.complementaryinformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, dateconclusionL, typeofActivitie, typeofexection, priority, state, decision, coment, complementaryinformation);
    }

    @Override
    public String toString() {
        return ", dateconclusionL=" + dateconclusionL +
                ", typeofActivitie=" + typeofActivitie +
                ", typeofexection=" + typeofexection +
                ", priority=" + priority +
                ", state=" + state +
                ", decision=" + decision +
                ", coment=" + coment +
                ", complementaryinformation=" + complementaryinformation;
    }
}
