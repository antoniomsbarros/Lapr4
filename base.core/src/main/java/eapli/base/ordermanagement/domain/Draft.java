package eapli.base.ordermanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.Calendars;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.io.File;
import java.util.Calendar;

@Entity
public class Draft implements AggregateRoot<Long> {
    @Id
    @GeneratedValue
    private  Long id;
    @Version
    private Long version;
    private String file;

    @Temporal(TemporalType.DATE)
    private Calendar deadline;

    @ManyToOne
    private ClientUser collaborator;

    private Long urgency;

    private String assigned;

    public Draft() {
    }

    public Draft(final ClientUser clientUser, final String assigned, final String filepath,final Calendar deadline,final Long urgency)  {
        Preconditions.noneNull(assigned,filepath,deadline, urgency,clientUser);
        this.file = filepath;
        this.deadline = deadline;
        this.urgency = urgency;
        this.assigned=assigned;
        this.collaborator=clientUser;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Draft)){
            return  false;
        }
        final  Draft draft=(Draft) other;
        if (this== draft){
            return true;
        }
        return identity().equals(draft.identity()) && deadline.equals(draft.deadline) && file.equals(draft.file)
                && assigned.equals(draft.assigned) && collaborator.sameAs(draft.collaborator);
    }

    @Override
    public Long identity() {
        return this.id;
    }
    public Calendar date(){
        return  deadline;
    }
    public Number urgency(){
        return  urgency;
    }
    public  String filepath(){
        return  file;
    }
    public  String assigned(){
        return assigned;
    }
    public ClientUser collaborator(){
        return  this.collaborator;
    }
    @Override
    public String toString() {
        return "id=" + id +  ", deadline=" + Calendars.format(deadline) + ", urgency=" + urgency.toString();
    }
}
