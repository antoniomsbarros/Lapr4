package eapli.base.catalogmanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.ordermanagement.domain.Form;
import eapli.base.ordermanagement.domain.State;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
public class Activity implements AggregateRoot<Long>  {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;
    private Calendar dateconclusionL;
    @Enumerated(EnumType.STRING)
    private TypeofActivitie typeofActivitie;
    @AttributeOverride(name = "value", column = @Column(name = "typeofexection"))
    private Description typeofexection;
    private Long priority;
    @Enumerated(EnumType.STRING)
    private State state;
    @AttributeOverride(name = "value", column = @Column(name = "decision"))
    private Description decision;
    @AttributeOverride(name = "value", column = @Column(name = "coment"))
    private Description coment;
    @AttributeOverride(name = "value", column = @Column(name = "complementaryinformation"))
    private Description complementaryinformation;


    @OneToOne
    private ClientUser collaborator;
    @OneToOne()
    private Form form;
    @OneToOne()
    private Sequence sequence;
    @OneToOne()
    private Criticalitylevel criticalitylevel;

    @OneToOne()
    private Responsable responsable;

    public Activity() {
    }

    public Activity(Responsable responsable, Criticalitylevel criticalitylevel, Sequence sequence, Form form, ClientUser collaborator, Calendar dateconclusionL, TypeofActivitie typeofActivitie,
                    Description typeofexection, Long priority, State state, Description decision, Description coment,
                    Description complementaryinformation) {
        Preconditions.noneNull(criticalitylevel, sequence,form,dateconclusionL,typeofActivitie,typeofexection,  priority, state,collaborator);
        this.dateconclusionL = dateconclusionL;
        this.typeofActivitie = typeofActivitie;
        this.typeofexection = typeofexection;
        this.priority = priority;
        this.state = state;
        this.decision = decision;
        this.coment = coment;
        this.complementaryinformation = complementaryinformation;
        this.collaborator=collaborator;
        this.form=form;
        this.sequence = sequence;
        this.criticalitylevel=criticalitylevel;
        this.responsable=responsable;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Activity)){
            return false;
        }
        Activity activity=(Activity) other;
        if (this==activity){
            return true;
        }
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
        return id.equals(activity.id) && version.equals(activity.version) && dateconclusionL.equals(activity.dateconclusionL) && typeofActivitie == activity.typeofActivitie && typeofexection.equals(activity.typeofexection) && priority.equals(activity.priority) && state == activity.state && decision.equals(activity.decision) && coment.equals(activity.coment) && complementaryinformation.equals(activity.complementaryinformation) && collaborator.equals(activity.collaborator) && form.equals(activity.form) && sequence.equals(activity.sequence) && criticalitylevel.equals(activity.criticalitylevel) && responsable.equals(activity.responsable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, dateconclusionL, typeofActivitie, typeofexection, priority, state, decision, coment, complementaryinformation, collaborator, form, sequence, criticalitylevel, responsable);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", version=" + version +
                ", dateconclusionL=" + dateconclusionL +
                ", typeofActivitie=" + typeofActivitie +
                ", typeofexection=" + typeofexection +
                ", priority=" + priority +
                ", state=" + state +
                ", decision=" + decision +
                ", coment=" + coment +
                ", complementaryinformation=" + complementaryinformation +
                ", collaborator=" + collaborator +
                ", form=" + form +
                ", order=" + sequence +
                ", criticalitylevel=" + criticalitylevel +
                ", responsable=" + responsable +
                '}';
    }

    public Responsable responsable() {
        return responsable;
    }
    public State state(){return state;}
    public Long priorityofActivity(){
        return  priority;
    }
    public String deadline(){
       /* if (dateconclusionL.getTime().after(new Date())){
            Date date1 = new Date();
            Date date2 = dateconclusionL.getTime();
            // Calucalte time difference in milliseconds
            long time_difference = date2.getTime() - date1.getTime();
            // Calucalte time difference in days
            long days_difference = (time_difference / (1000*60*60*24)) % 365;
            // Calucalte time difference in years
            long years_difference = (time_difference / (1000l*60*60*24*365));
            // Calucalte time difference in seconds
            long seconds_difference = (time_difference / 1000)% 60;
            // Calucalte time difference in minutes
            long minutes_difference = (time_difference / (1000*60)) % 60;

            // Calucalte time difference in hours
            long hours_difference = (time_difference / (1000*60*60)) % 24;
            return dateconclusionL.getTime().toString()+" Remaning time:"
                    + " hours: "+hours_difference
                    + " minutes: "+ minutes_difference
                    + " seconds: "+ seconds_difference
                    + " years: "+ years_difference
                    + " days: "+ days_difference ;
        }*/
        return dateconclusionL.getTime().toString();
    }

    public Criticalitylevel criticalitylevel(){
        return criticalitylevel;
    }
    public Calendar date(){
        return  dateconclusionL;
    }
}
